package controler;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import data.constantes.ConstantesStatics;

public class GameSound {
	
	private AudioClip soundTakeCard;
    private AudioClip soundShuffleCards;
    private AudioClip soundLayCards;
    
    public GameSound() {
    	creerLesSonsDuJeu();
	}

	private void creerLesSonsDuJeu()  {
    	
		try {
			URL urlTakeCard = new URL("file", "",  ConstantesStatics.RACINE_STATICS_SOUND + "takeCard.wav");
			URL urlShuffleCards = new URL("file", "" , ConstantesStatics.RACINE_STATICS_SOUND + "shuffleCards.wav");
	    	URL urlLayCards = new URL("file","",ConstantesStatics.RACINE_STATICS_SOUND + "layCards.wav");
	    	setSoundTakeCard(Applet.newAudioClip(urlTakeCard));
	    	setSoundShuffleCards(Applet.newAudioClip(urlShuffleCards));
	    	setSoundLayCards(Applet.newAudioClip(urlLayCards));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
	}

	public AudioClip getSoundTakeCard() {
		return soundTakeCard;
	}

	public void setSoundTakeCard(AudioClip soundTakeCard) {
		this.soundTakeCard = soundTakeCard;
	}

	public AudioClip getSoundShuffleCards() {
		return soundShuffleCards;
	}

	public void setSoundShuffleCards(AudioClip soundShuffleCards) {
		this.soundShuffleCards = soundShuffleCards;
	}

	public AudioClip getSoundLayCards() {
		return soundLayCards;
	}

	public void setSoundLayCards(AudioClip soundLayCards) {
		this.soundLayCards = soundLayCards;
	}
}
