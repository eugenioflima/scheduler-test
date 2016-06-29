package br.gov.frameworkdemoiselle.component.scheduler.teste.concorrencia.business;

import java.io.Serializable;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.component.scheduler.teste.concorrencia.domain.Bookmark;
import br.gov.frameworkdemoiselle.scheduler.lifecycle.Schedule;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

@BusinessController
public class JobA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int count;
	
	@Inject
	private BookmarkBC bookmarkBC;
	
	@Schedule(cron = SchedulerUtils.DEFAULT_CRON)
	public void execute() throws InterruptedException {
		Thread.sleep(1000);
		count++;
		Bookmark bookmark = new Bookmark();
		bookmark.setDescription("Teste " + String.format("%03d", count));
		bookmark.setLink("host.com/test/" + count);
		bookmarkBC.insert(bookmark);
	}
}
