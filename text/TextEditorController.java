import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
    This class allows you to create new text files and open existing text 
    files. The file contents are to be displayed in a TextArea text area. The
    application has menu items to change the font and style of the text that 
    is displayed in the text area.

    @author Jeremy Hill
    @version 1.8.0_271
 */
public class TextEditorController 
{
    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private MenuItem saveAsMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private Menu fontMenu;

    @FXML
    private RadioMenuItem monoMenuItem;

    @FXML
    private ToggleGroup radioFontChoices;

    @FXML
    private RadioMenuItem serifMenuItem;

    @FXML
    private RadioMenuItem sansMenuItem;

    @FXML
    private CheckMenuItem italicMenuItem;

    @FXML
    private CheckMenuItem boldMenuItem;

    @FXML
    private TextArea textArea;

    private String currentFont = "";                //holds the current font

    private final int FONTSIZE = 12;                //holds default font size

    private File filename = null;                   //holds the current file


    /**
    * This method runs when the italic check menu item is selected. If italic
    * is selected, then italics will be turned on. If italic is unselected, 
    * then italics will be turned off.
    */
    @FXML
    private void italicMenuItemListener() 
    {
        if (italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, 
                                               FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (!italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, FONTSIZE);
            textArea.setFont(font);
        }
        else if (!italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FONTSIZE);
            textArea.setFont(font);
        }
    }

    /**
    * This method runs when the bold check menu item is selected. If bold
    * is selected, then bold text will be turned on. If bold is unselected, 
    * then bold text will be turned off.
    */
    @FXML
    private void boldMenuItemListener() 
    {
        if (!italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, 
                                               FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (!italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FONTSIZE);
            textArea.setFont(font);
        }
    }


    /**
    * This method runs when the Monospaced radio button is selected. The font
    * will be changed to Monospaced with italics and bold text being unchanged.
    */
    @FXML
    private void monoMenuItemListener() 
    {
        currentFont = "Monospaced";

        if (!italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FONTSIZE);
            textArea.setFont(font);
        }
        else if (!italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, 
                                               FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
    }


    /**
    * This method runs when the Serif radio button is selected. The font
    * will be changed to Serif with italics and bold text being unchanged.
    */
    @FXML
    private void serifMenuItemListener() 
    {
        currentFont = "Serif";

        if (!italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FONTSIZE);
            textArea.setFont(font);
        }
        else if (!italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, 
                                               FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
    }


    /**
    * This method runs when the SansSerif radio button is selected. The font
    * will be changed to SansSerif with italics and bold text being unchanged.
    */
    @FXML
    private void sansMenuItemListener() 
    {
        currentFont = "SansSerif";

        if(!italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FONTSIZE);
            textArea.setFont(font);
        }
        else if(!italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, FONTSIZE);
            textArea.setFont(font);
        }
        else if(italicMenuItem.isSelected() && boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontWeight.BOLD, 
                                               FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
        else if (italicMenuItem.isSelected() && !boldMenuItem.isSelected())
        {
            Font font = Font.font(currentFont, FontPosture.ITALIC, FONTSIZE);
            textArea.setFont(font);
        }
    }


    /**
    * This method is called when the "New" menu item is selected. It clears the 
    * text stored in the textArea. In addition, the current file field is set 
    * to null.
    */
    @FXML
    private void newMenuItemListener() 
    {
        filename = null;
        textArea.setText(null);        
    }


    /**
    * This method is called when the "Open" menu item is selected. It displays 
    * a file chooser that allows the user to select a file, from any directory,
    * to open. Once selected, the file is opened and its contents are displayed
    * in the text area. The path and name of the file are stored in the 
    * filename field.
    */
    @FXML
    private void openMenuItemListener() 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        filename = fileChooser.showOpenDialog(null);

        try (Scanner input = new Scanner(filename)) 
        {
            String text = "";
            while (input.hasNextLine()) 
            {
               text = text + input.nextLine() + "\n";
            }
            textArea.setText(text);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }


    /**
    * This method is called when the "Save" menu item is selected. If 
    * the filename is null, then this method calls the the save as
    * method. If the filename is not null, then the saveFile method
    * is called passing the textArea and filename.
    */
    @FXML
    private void saveMenuItemListener() 
    {
        if(filename != null)
        {
            saveFile(textArea.getText(), filename);
        }
        else
        {
            saveAsMenuItemListener();
        }
    }


    /**
    * This method is called when the "Save As" menu item is selected. It 
    * displays a file chooser that allows the user to select a location and
    * file name. The contents of the text area are written to the selected 
    * file, and the path and file name are stored in the filename field by
    * calling the saveFile method.
    */
    @FXML
    private void saveAsMenuItemListener() 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters()
                   .addAll(new ExtensionFilter("All Files", "*.*"));
        saveFile(textArea.getText(), fileChooser.showSaveDialog(null));
    }


    /**
    * This method saves the contents of the text area. The contents are saved
    * to the file with the name and path stored in the filename field.
    * @param content The contents of the textArea.
    * @param file The filename to save the file as.
    */
    private void saveFile(String content, File file)
    {
        try 
        {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }


    /**
    * This method is called when the "Exit" menu item is selected. It
    * ends the application.
    */
    @FXML
    private void exitMenuItemListener() 
    {
        System.exit(0);
    }
}