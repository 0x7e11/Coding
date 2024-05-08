package com.example.Coding;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

public class HelloController {
    public File selectedFile;

    public String base64EncodedString;

    @FXML
    private Button coding_id;

    @FXML
    private Button copy_id;

    @FXML
    private Button shangchuan_id;

    @FXML
    private TextArea shuchu_id;

    @FXML
    private ChoiceBox<String> code_choice;


    @FXML
    void shangchuan(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");
        fileChooser.setInitialDirectory(new File("C:"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("*", "*")
        );
        selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile == null) {
            return;
        }
//        System.out.println(selectedFile.getAbsolutePath());


    }

    @FXML
    void coding(ActionEvent event) {
        if(code_choice.getValue().equals("base64")){
            try {
                // 读取文件内容并转换为字节数组
                byte[] fileContent = Files.readAllBytes(selectedFile.toPath());

                // 对字节数组进行 Base64 编码
                base64EncodedString = Base64.getEncoder().encodeToString(fileContent);

                // 输出 Base64 编码后的字符串
//                System.out.println("Base64 编码后的字符串:\n" + base64EncodedString);
                shuchu_id.setText(base64EncodedString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @FXML
    void copy(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(base64EncodedString);
        clipboard.setContent(content);
    }

    public void initialize(){
        code_choice.setItems(FXCollections.observableArrayList("base64"));
        code_choice.setValue("base64");
        shuchu_id.setWrapText(true); //输出栏设置为自动换行


    }

}
