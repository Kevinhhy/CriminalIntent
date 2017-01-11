package database.CrimeDbSchema;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.kevin.criminalintent.Crime;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kevin on 2017/1/10.
 */

public class CrimeCusorWrapper extends CursorWrapper {
    public CrimeCusorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidStriing = getString(getColumnIndex((CrimeDbSchema.CrimeTable.Cols.UUID)));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidStriing));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspect);
        return crime;
    }
}
