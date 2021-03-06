package bat.string1;

import plm.universe.bat.BatEntity;
import plm.universe.bat.BatTest;

public class StringBitsEntity extends BatEntity {
    public void run(BatTest t) {
        t.setResult(stringBits((String) t.getParameter(0)));
    }

    /* BEGIN TEMPLATE */
    String stringBits(String str) {
        /* BEGIN SOLUTION */
        String result = "";
        // Note: the loop increments i by 2
        for (int i = 0; i < str.length(); i += 2) {
            result = result + str.substring(i, i + 1);
            // Alternately could use str.charAt(i)
        }
        return result;
		/* END SOLUTION */
    }
	/* END TEMPLATE */
}
