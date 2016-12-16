package com.project.thurnandtaxis.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Official;

public class ParserXML {
    
    private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    public Element recupererFichierXMLBySAXBuilder(final String nomFichier) throws FileNotFoundException {
        
        final SAXBuilder sxb = new SAXBuilder();

        Document document = null;

        try {
            document = sxb.build(new File(nomFichier));
        } catch (JDOMException | IOException e) {
            throw new FileNotFoundException("Le fichier \"" + nomFichier + "\" n'a pas été trouvé.");
        }

        return document.getRootElement();
    }
    
    public JSONObject recupererGameElementsEnJSON(String nomFichier) throws IOException {

        final String xml = FileUtils.readFileToString(new File(nomFichier), StandardCharsets.UTF_8);
        final JSONObject xmlToJSON = XML.toJSONObject(xml);

        return xmlToJSON.getJSONObject("game_elements");
    }
    
    public void xmlToJson(JSONObject xmlJSONObj) throws JSONException, IOException {
        
        final String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
    }
    
    // Ajouter cette méthodes à la classe JDOM2
    public void afficheALLEtudiant(final Element racine) {
        // On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        final List<Element> listEtudiants = racine.getChildren("etudiant");
        
        // On crée un Iterator sur notre liste
        final Iterator<Element> i = listEtudiants.iterator();
        while (i.hasNext()) {
            // On recrée l'Element courant à chaque tour de boucle afin de
            // pouvoir utiliser les méthodes propres aux Element comme :
            // sélectionner un nœud fils, modifier du texte, etc...
            final Element courant = i.next();
            // On affiche le nom de l’élément courant
            System.out.println(courant.getChild("nom").getText());
        }
    }

    public List<Official> recupererListeOfficialsXML(Element racine) {

        final List<Official> listeOfficials = Lists.newArrayList();

        final Element officials = racine.getChild("officials");
        final List<Element> listOfficials = officials.getChildren("official");
        final Iterator<Element> i = listOfficials.iterator();
        
        while (i.hasNext()) {
            final Element courant = i.next();
            // On ajoute l'official dans la liste
            final Official official = new Official();
            official.setNom(courant.getChild("name").getText());
            official.setSymbolImage(courant.getChild("symbol_image").getText());
            official.setPersonImage(courant.getChild("person_image").getText());
            listeOfficials.add(official);
        }

        return listeOfficials;
    }

    public List<Official> recupererListeOfficialsJSON(final JSONObject jsonOfficials) {

        final List<Official> listeOfficials = Lists.newArrayList();

        final JSONArray officials = (JSONArray) jsonOfficials.get("official");

        for (int i = 0; i < officials.length(); i++) {
            JSONObject obj = officials.getJSONObject(i);
            // On ajoute l'official dans la liste
            final Official official = new Official();
            official.setNom(obj.getString("name"));
            official.setSymbolImage(obj.getString("symbol_image"));
            official.setPersonImage(obj.getString("person_image"));
            listeOfficials.add(official);
        }
        
        return listeOfficials;
    }
    
    public void afficheALLOfficial(Element racine) {
        // On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        Element officials = racine.getChild("officials");
        final List<Element> listOfficials = officials.getChildren("official");
        
        // On crée un Iterator sur notre liste
        final Iterator<Element> i = listOfficials.iterator();
        while (i.hasNext()) {
            // On recrée l'Element courant à chaque tour de boucle afin de
            // pouvoir utiliser les méthodes propres aux Element comme :
            // sélectionner un nœud fils, modifier du texte, etc...
            final Element courant = i.next();
            // On affiche le nom de l’élément courant
            System.out.println(courant.getChild("name").getText());
        }
        
    }
    
}
