package br.com.guacom.enterprise.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class OnlyString extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 228762503966020205L;

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		super.insertString(offs, str.replaceAll("[^a-zA-Z\\W]", ""), a);
	}
}