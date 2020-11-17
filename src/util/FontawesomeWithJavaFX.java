package util; /**
 * The MIT License
 * 
 * Copyright (c) 2016 Shell Technologies PTY LTD. http://au.shellpays.com
 *
 * You may obtain a copy of the License at
 * 
 *       http://mit-license.org/
 *       
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Steven Chen
 *
 */
public class FontawesomeWithJavaFX  {
	//private static final Font GLYPH_FONTAWESOME;
	public static final Map<String,Character> GLYPH_MAP;

	static {
		GLYPH_MAP = new HashMap<String, Character>();
        GLYPH_MAP.put("arrow-left",'\uf060');
        GLYPH_MAP.put("arrow-right",'\uf061');
        GLYPH_MAP.put("undo",'\uf0e2');
        GLYPH_MAP.put("chevron-right",'\uf054');
        GLYPH_MAP.put("download",'\uf019');
        GLYPH_MAP.put("lock",'\uf023');
        GLYPH_MAP.put("lock-open",'\uf3c1');
        GLYPH_MAP.put("certificate",'\uf0a3');
        GLYPH_MAP.put("cookie",'\uf563');
        GLYPH_MAP.put("history",'\uf1da');
        GLYPH_MAP.put("user",'\uf2bd');
        GLYPH_MAP.put("ellipsis-h",'\uf141');
        GLYPH_MAP.put("plus",'\uf067');
        GLYPH_MAP.put("file",'\uf15b');
        GLYPH_MAP.put("pause",'\uf04c');
        GLYPH_MAP.put("play",'\uf04b');
        GLYPH_MAP.put("stop",'\uf04d');
	}
    public static Button createGlyphButton(Font font,String glyphName, int sizeFactor,String text) {
        Label lbl = new Label();
        lbl.setFont(Font.font(font.getFamily(), 1 * sizeFactor));
        lbl.setText(String.valueOf(FontawesomeWithJavaFX.GLYPH_MAP.get(glyphName)));
        Button btn = new Button(text,lbl);
//		btn.setWrapText(true);
        //btn.setContentDisplay(ContentDisplay.CENTER);
        return btn;
    }

     public static Label createGlyphLabel(Font font, String glyphName, int sizeFactor,String textString) {
        Label label = new Label("");
        label.setFont(Font.font(font.getFamily(), 1 * sizeFactor));
        System.out.println("手动"+font.getFamily());
        label.setText(String.valueOf(FontawesomeWithJavaFX.GLYPH_MAP.get(glyphName)));
        return label;
    }
    public static Label httpCreateGlyphLabel(Font font, String glyphName, int sizeFactor,String textString) {
        Label label = new Label();
        label.setFont(Font.font(font.getFamily(), 1 * sizeFactor));
        label.setText(String.valueOf(FontawesomeWithJavaFX.GLYPH_MAP.get(glyphName))+" HTTPS");
        return label;
    }







}
