package com.project.thurnandtaxis.services.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.google.common.collect.Lists;
import com.project.thurnandtaxis.data.beans.Official;

public class ParserXML {

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

    public List<Official> recupererListeOfficialsXML(Element racine) {
        
        final List<Official> listeOfficials = Lists.newArrayList();
        
        final Element officials = racine.getChild("officials");
        final List<Element> listOfficials = officials.getChildren("official");
        final Iterator<Element> i = listOfficials.iterator();

        while (i.hasNext()) {
            final Element courant = i.next();
            // On ajoute l'official dans la liste
            final Official official = new Official();
            official.setName(courant.getChild("name").getText());
            official.setImage(new ImageIcon(courant.getChild("symbol_image").getText()));
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
