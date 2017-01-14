package com.project.thurnandtaxis.services;


public class PDFapercu {
    // PDFFile pdffile;
    // PDFPage page;
    // JPanel panneau;
    // String nomFichier = "";
    //
    // // Construct
    // public PDFapercu(String nomFichier) {
    // this.nomFichier = nomFichier;
    // SwingUtilities.invokeLater(new Runnable() {
    // @Override
    // public void run() {
    // try {
    // PdfApercu.this.previewPDFDocumentInImage();
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // }
    // });
    // }
    //
    // public void createPage() throws IOException {
    // this.panneau = new JPanel();
    //
    // // Chargement du pdf
    // // File file = new File("c:/temp/monFichier.pdf");
    // File file = new File(this.nomFichier);
    // RandomAccessFile raf = new RandomAccessFile(file, "r");
    // FileChannel channel = raf.getChannel();
    // ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
    //
    // this.pdffile = new PDFFile(buf);
    //
    // // on affiche la premiere page
    // this.goToPage(1);
    // }
    //
    // public void goToPage(int nbpage) throws IndexOutOfBoundsException {
    // if ((nbpage < 1) || (nbpage > this.pdffile.getNumPages())) {
    // throw new IndexOutOfBoundsException("index invalide demande : " + nbpage);
    // }
    // this.page = this.pdffile.getPage(nbpage);
    //
    // }
    //
    // public void previewPDFDocumentInImage() throws IOException {
    //
    // this.createPage();
    //
    // // get the width and height for the doc at the default zoom
    // Rectangle rect = new Rectangle(0, 0, (int) this.page.getBBox().getWidth(), (int) this.page.getBBox().getHeight());
    //
    // // generate the image
    // Image img = this.page.getImage(rect.width, rect.height, // width & height
    // rect, // clip rect
    // null, // null for the ImageObserver
    // true, // fill background with white
    // true) // block until drawing is done
    // ;
    // JScrollPane scroller = new JScrollPane(new JLabel(new ImageIcon(img)));
    // // show the image in a frame
    // JFrame frame = new JFrame("yes yes yes  PDF document");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // // frame.add(new JLabel(new ImageIcon(img)));
    // frame.add(scroller);
    // frame.pack();
    // frame.setVisible(true);
    // }
}