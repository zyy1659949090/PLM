package plm.core.ui;

import java.util.Locale;

import javax.swing.JFrame;

import plm.core.HumanLangChangesListener;
import plm.core.ProgLangChangesListener;
import plm.core.lang.ProgrammingLanguage;
import plm.core.model.Game;
import plm.core.model.lesson.Exercise;
import plm.core.model.lesson.Exercise.WorldKind;
import plm.core.model.lesson.Lecture;


public class AboutWorldDialog extends AbstractAboutDialog implements ProgLangChangesListener, HumanLangChangesListener {

	private static final long serialVersionUID = 1766486738385426108L;

	public AboutWorldDialog(JFrame parent) {
		super(parent);
		currentExerciseHasChanged(game.getCurrentLesson().getCurrentExercise());
		game.addProgLangListener(this);
		game.addHumanLangListener(this);
	}

	@Override
	public void currentExerciseHasChanged(Lecture lecture) {
		if (lecture instanceof Exercise) {
			Exercise exo = (Exercise) lecture;
			setTitle(Game.i18n.tr("About world - {0}",
					exo.getWorlds(WorldKind.CURRENT).get(0).getClass().getSimpleName()));
			area.setText(exo.getWorlds(WorldKind.CURRENT).get(0).getAbout());
			area.setCaretPosition(0);
		} else {
			// FIXME: should disable the entry menu when seing a lecture, and close any preexisting window when switching to a lecture
			setVisible(false);
		}
	}

	@Override
	public void currentProgrammingLanguageHasChanged(ProgrammingLanguage newLang) {
		int pos = area.getCaretPosition();
		area.setText(((Exercise) game.getCurrentLesson().getCurrentExercise()).getWorlds(WorldKind.CURRENT).get(0).getAbout());
		area.setCaretPosition(pos);
	}

	@Override
	public void currentHumanLanguageHasChanged(Locale newLang) {
		setTitle(Game.i18n.tr("About world - {0}",
				((Exercise) game.getCurrentLesson().getCurrentExercise()).getWorlds(WorldKind.CURRENT).get(0).getClass().getSimpleName()));
	}
}
