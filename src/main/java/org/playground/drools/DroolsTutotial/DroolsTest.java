package org.playground.drools.DroolsTutotial;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
	public static void main(String[] args) {
		 GregorianCalendar time = new GregorianCalendar();
		  int hour = time.get(Calendar.HOUR_OF_DAY);
		DroolsTest droolsTest = new DroolsTest();
		//droolsTest.execute(1);
		droolsTest.execute(hour);
		//droolsTest.execute(17);
	}

	public void execute(int time) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		Person person = new Person();
		person.setName("My dear");
		person.setTime(time);
		kSession.insert(person);
		kSession.fireAllRules();
	}

}
