package variables;

import java.util.Locale;

import org.xnap.commons.i18n.I18n;

import plm.core.model.I18nManager;

public class VariablesCommonErr2 extends plm.universe.bugglequest.SimpleBuggle {
	@Override
	public void forward(int i) {
		Locale locale = getWorld().getLocale();
		I18n i18n = I18nManager.getI18n(locale);
		throw new RuntimeException(i18n.tr("Sorry Dave, I cannot let you use forward with an argument in this exercise. Use a loop instead."));
	}

	@Override
	public void backward(int i) {
		Locale locale = getWorld().getLocale();
		I18n i18n = I18nManager.getI18n(locale);
		throw new RuntimeException(i18n.tr("Sorry Dave, I cannot let you use backward with an argument in this exercise. Use a loop instead."));
	}


	@Override
	public void run() {
		int nbSteps = 0;
		while(!isOverBaggle()) {
			forward();
			nbSteps++;
		}
		int alreadyDone = 0;
		while(alreadyDone != nbSteps) {
			backward();
			alreadyDone++;
		}
	}
}
