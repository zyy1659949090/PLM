package bat.string1;

import plm.core.model.lesson.ExerciseTemplated;
import plm.core.utils.FileUtils;
import plm.universe.bat.BatTest;
import plm.universe.bat.BatWorld;

public class StringMatch extends ExerciseTemplated {
    public StringMatch(FileUtils fileUtils) {
        super("StringMatch");

        BatWorld myWorld = new BatWorld(fileUtils, "stringMatch");
        myWorld.addTest(BatTest.VISIBLE, "xxcaazz", "xxbaaz");
        myWorld.addTest(BatTest.VISIBLE, "abc", "abc");
        myWorld.addTest(BatTest.VISIBLE, "abc", "axc");
        myWorld.addTest(BatTest.INVISIBLE, "hello", "he");
        myWorld.addTest(BatTest.INVISIBLE, "he", "hello");
        myWorld.addTest(BatTest.INVISIBLE, "h", "hello");
        myWorld.addTest(BatTest.INVISIBLE, "", "hello");
        myWorld.addTest(BatTest.INVISIBLE, "aabbccdd", "abbbxxd");
        myWorld.addTest(BatTest.INVISIBLE, "aaxxaaxx", "iaxxai");
        myWorld.addTest(BatTest.INVISIBLE, "iaxxai", "aaxxaaxx");

        setup(myWorld);
    }
}
