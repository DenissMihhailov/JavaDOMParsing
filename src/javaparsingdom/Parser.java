/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparsingdom;

import entity.Channel;
import entity.Channels;
import entity.Program;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Deniss
 */
public class Parser {
    
    public Channels parse(){
        
        Channels channelsRoot = new Channels();
        
        File file = new File("src\\javaparsingdom\\TVProgram.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // Конструктор
        Document doc = null;
        try {
            doc = dbf.newDocumentBuilder().parse(file); // Запарсил
        } catch (Exception e) {
            System.out.println("Open parsing error:" + e.toString());
            return null;
        }
        
        Node rootElement = doc.getFirstChild();
        
        NodeList channelsTag = rootElement.getChildNodes();
        Node channels = null;
        for (int i = 0; i < channelsTag.getLength(); i++) {
            if (channelsTag.item(i).getNodeType()!=Node.ELEMENT_NODE) {continue;}
            channels = channelsTag.item(i);
        }
        List <Channel> channelsList = channels(channels);
        channelsRoot.setChannels(channelsList);
        return channelsRoot;
    }
    
    private List<Channel> channels(Node channels){
        List<Channel> channelsList = new ArrayList();
        NodeList channel = channels.getChildNodes();
        for (int i = 0; i < channel.getLength(); i++) {
            List<Program> programsList = new ArrayList();
            Channel channelEntity = new Channel();
            if (channel.item(i).getNodeType()!=Node.ELEMENT_NODE) {continue;}
            Element e = (Element)channel.item(i);
            String name = e.getAttribute("name");
            channelEntity.setName(name);
            
            NodeList channelElements = channel.item(i).getChildNodes();
            for (int j = 0; j < channelElements.getLength(); j++) {
                if (channelElements.item(j).getNodeType()!=Node.ELEMENT_NODE) {continue;}
                switch(channelElements.item(j).getNodeName()){
                    case "logo":
                        channelEntity.setLogo(channelElements.item(j).getTextContent());
                        break;
                    case "programs":
                        NodeList programsTag = channelElements.item(j).getChildNodes();
                        for (int k = 0; k < programsTag.getLength(); k++) {
                            if (programsTag.item(k).getNodeType()!=Node.ELEMENT_NODE) {continue;}
                            Program programEntity = new Program();
                            Element el = (Element)programsTag.item(k);
                            NodeList programs = programsTag.item(k).getChildNodes();
                            for (int l = 0; l < programs.getLength(); l++) {
                                if (programs.item(l).getNodeType()!=Node.ELEMENT_NODE) {continue;}
                                programEntity.setTitle(el.getAttribute("title"));
                                //System.out.println(programs.item(l).getNodeName());.
                                switch(programs.item(l).getNodeName()){
                                    case "image":
                                        programEntity.setImage(programs.item(l).getTextContent());
                                        break;
                                    case "date": 
                                        programEntity.setDate(programs.item(l).getTextContent());
                                        break;
                                    case "timeS":
                                        programEntity.setTimeS(programs.item(l).getTextContent());
                                        break;
                                    case "timeF":
                                        programEntity.setTimeF(programs.item(l).getTextContent());
                                        break;
                                    case "age":
                                        programEntity.setAge(programs.item(l).getTextContent());
                                        break;
                                    case "category":
                                        programEntity.setCategory(programs.item(l).getTextContent());
                                        break;
                                    case "description":
                                        programEntity.setDescription(programs.item(l).getTextContent());
                                        break;
                                }
                                
                            }
                                programsList.add(programEntity);
                        }
                        break;
                }
            }
            channelEntity.setPrograms(programsList);
            channelsList.add(channelEntity);
        }
        return channelsList;
    }
    
}
