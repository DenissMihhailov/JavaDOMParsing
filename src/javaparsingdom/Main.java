/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparsingdom;

import entity.Channel;
import entity.Channels;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Deniss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Parser parser = new Parser();
        Channels root = parser.parse();
 
        List <Channel> channelsList = root.getChannels();
        
        //===============================CSS====================================
        try {
        File fileCSS = new File("style.css"); 
        if(!fileCSS.exists())
        fileCSS.createNewFile();
        PrintWriter pw = new PrintWriter(fileCSS);
        
        pw.print("@import url(\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap\");\n" +
                "* {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "  box-sizing: border-box;\n" +
                "  font-family: \"Poppins\", sans-serif;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  align-items: center;\n" +
                "  flex-wrap: wrap;\n" +
                "  min-height: 100vh;\n" +
                "  background: #232427;\n" +
                "}\n" +
                "\n" +
                "body .container {\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  align-items: center;\n" +
                "  flex-wrap: wrap;\n" +
                "  margin: 100px 0 0 0;\n" +
                "\n" +
                "}\n" +
                ".img{\n" +
                "    width: inherit;\n" +
                "    height: inherit;\n" +
                "    opacity: 0.7;\n" +
                "}\n" +
                "body .container .card {\n" +
                "  position: relative;\n" +
                "  min-width: 370px;\n" +
                "  height: 280px;\n" +
                "  box-shadow: inset 5px 5px 5px rgba(0, 0, 0, 0.2),\n" +
                "    inset -5px -5px 15px rgba(255, 255, 255, 0.1),\n" +
                "    5px 5px 15px rgba(0, 0, 0, 0.3), -5px -5px 15px rgba(255, 255, 255, 0.1);\n" +
                "  border-radius: 15px;\n" +
                "  margin: 5px;\n" +
                "  transition: 0.5s;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box {\n" +
                "  position: absolute;\n" +
                "  top: 20px;\n" +
                "  left: 20px;\n" +
                "  right: 20px;\n" +
                "  bottom: 20px;\n" +
                "  background: #2a2b2f;\n" +
                "  border-radius: 15px;\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  align-items: center;\n" +
                "  overflow: hidden;\n" +
                "  transition: 0.5s;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box:hover {\n" +
                "  transform: translateY(-25px);\n" +
                "}\n" +
                "\n" +
                "body .container .card .box:before {\n" +
                "  content: \"\";\n" +
                "  position: absolute;\n" +
                "  top: 0;\n" +
                "  left: 0;\n" +
                "  width: 50%;\n" +
                "  height: 100%;\n" +
                "  background: rgba(255, 255, 255, 0.03);\n" +
                "}\n" +
                "\n" +
                "body .container .card .box .content {\n" +
                "  padding: 20px;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box .content h2 {\n" +
                "  position: absolute;\n" +
                "  top: -10px;\n" +
                "  right: 2px;\n" +
                "  font-size: 8rem;\n" +
                "  color: rgba(255, 255, 255, 0.1);\n" +
                "  width: 330px;\n" +
                "  height: 250px;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box .content h3 {\n" +
                "  font-size: 1.8rem;\n" +
                "  color: #fff;\n" +
                "  z-index: 1;\n" +
                "  transition: 0.5s;\n" +
                "  position: relative;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box .content p {\n" +
                "  font-size: 1rem;\n" +
                "  font-weight: 300;\n" +
                "  color: rgba(255, 255, 255, 0.9);\n" +
                "  z-index: 1;\n" +
                "  transition: 0.5s;\n" +
                "  position: relative;\n" +
                "}\n" +
                "\n" +
                "body .container .card .box .content a {\n" +
                "  position: relative;\n" +
                "  display: inline-block;\n" +
                "  padding: 8px 20px;\n" +
                "  background: #E91E62;\n" +
                "  border-radius: 5px;\n" +
                "  text-decoration: none;\n" +
                "  color: white;\n" +
                "  margin-top: 5px;\n" +
                "  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);\n" +
                "  transition: 0.5s;\n" +
                "  cursor: pointer;\n" +
                "}\n" +
                "body .container .card .box .content a:hover {\n" +
                "  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.6);\n" +
                "  background: #fff;\n" +
                "  color: #000;\n" +
                "}\n" +
                "\n" +
                ".title{  \n" +
                "    font-size: 2.4rem;\n" +
                "    font-weight: 700;\n" +
                "    color: #fff;\n" +
                "    margin-bottom: 15px;\n" +
                "    position: absolute;\n" +
                "    padding-bottom: 380px;\n" +
                "    z-index: -1;\n" +
                "}");
        pw.close();
        
        } catch (IOException e) {
            System.out.println("error"+ e);
        }
        //===============================CSS====================================
        
        //==============================HTML====================================
        try {
        File fileHTML = new File("index.html"); 
        if(!fileHTML.exists())
        fileHTML.createNewFile();
        PrintWriter pw = new PrintWriter(fileHTML);
        pw.print("<!DOCTYPE html>\n" +
                 "<html lang=\"en\">\n" +
                 "<head>\n" +
                 "    <meta charset=\"UTF-8\">\n" +
                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                 "    <title>ParseProject</title>\n" +
                 "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                 "</head>\n" +
                 "<body>\n");
        pw.println("");
        for (int i = 0; i < channelsList.size(); i++) {
            pw.println("    <div class=\"container\">");
            pw.printf("     <div class=\"title\">%s</div>\n", channelsList.get(i).getName());
            pw.println("");
            for (int k = 0; k < channelsList.get(i).getPrograms().size(); k++) {
            pw.println("        <div class=\"card\">");
            pw.println("            <div class=\"box\">");
            pw.println("                <div class=\"content\">");
            pw.printf("                 <h2><img class=\"img\" src=\"%s\"></h2>\n", channelsList.get(i).getPrograms().get(k).getImage());
            pw.printf("                 <strong><p style=\"font-weight: 700\">%s (%s)</p></strong>\n", channelsList.get(i).getPrograms().get(k).getTitle(), channelsList.get(i).getPrograms().get(k).getCategory());
            pw.printf("                 <p>%s</p>\n", channelsList.get(i).getPrograms().get(k).getDate());
            pw.printf("                 <p>%s-%s</p>\n", channelsList.get(i).getPrograms().get(k).getTimeS(), channelsList.get(i).getPrograms().get(k).getTimeF());
            pw.printf("                 <h3>%s</h3>\n", channelsList.get(i).getPrograms().get(k).getAge());
            pw.printf("                 <a onclick=\"alert('%s')\">Read More</a>\n", channelsList.get(i).getPrograms().get(k).getDescription());
            pw.println("                </div>");
            pw.println("            </div>");
            pw.println("        </div>");
            pw.println("");
            }       
            pw.println("    </div>");               
            pw.println("");               
        }
        pw.print("</body>\n" +
                 "</html>");
        pw.close();
        Desktop.getDesktop().open(fileHTML);
        } catch (IOException e) {
            System.out.println("error"+ e);
        }
        //==============================HTML====================================
    }
    
}
