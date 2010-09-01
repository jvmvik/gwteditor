package eu.unhook.gunhook.client;

import at.wizzart.gwt.widgets.client.CodeMirror;
import at.wizzart.gwt.widgets.client.CodeMirrorConfiguration;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import at.wizzart.gwt.widgets.client.event.logical.SaveEvent;
import at.wizzart.gwt.widgets.client.event.logical.SaveHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class editor implements EntryPoint {
	private CodeMirror editor;
	private CodeMirrorConfiguration config = new CodeMirrorConfiguration();

	// set up logging to catch exceptions in browser
	public void onModuleLoad() {

		config.setLineNumbers(true);
		config.setContinuousScanning(0);
		config.setTextWrapping(false);
		config.setAutoMatchParens(false);
		//config.setStyleSheetURL(GWT.getModuleBaseURL() + "/css/all.css");

		editor = new CodeMirror(config);
		editor.setHeight("100%");
		editor.setWidth("100%");

		editor.addInitializeHandler(new InitializeHandler() {
			public void onInitialize(InitializeEvent event) {
				editor.setParser(CodeMirror.PARSER_XML);
				editor.setLineNumbers(true);
				editor.setIndentUnit(2);
				editor.setTextWrapping(true);
				//editor.setStylesheetURL(GWT.getModuleBaseURL()+ "/css/editor.css");
				editor.setFocus();
				// editor.setSelection("body { \nmargin: 0px; \n}");
				editor.setContent("<xml>\n<test>CodeMirror integration</test>\n<langs>\n<lang>XML</lang>\n"
						+ "<lang>PERL</lang>\n<lang>...</lang>\n</langs>\n</xml>");
				editor.reindent();
			}
		});

		editor.addSaveHandler(new SaveHandler() {
			public void onSave(SaveEvent event) {
				Window.alert("saved!");
			}
		});

		RootPanel.get().add(editor);

	}
}
