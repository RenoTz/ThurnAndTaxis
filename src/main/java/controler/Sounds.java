package controler;

import model.constantes.ConstantesStatics;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Sounds {

	private AudioClip soundTakeCard;
	private AudioClip soundShuffleCards;
	private AudioClip soundLayCards; 
	private AudioClip soundButton;
	private AudioClip soundToggle;

	public Sounds() {
		this.creerLesSonsDuJeu();
	}

	private void creerLesSonsDuJeu() {

        final String pathSounds = this.getClass().getClassLoader().getResource(ConstantesStatics.RACINE_STATICS_SOUND).getPath();

		try {
            final URL urlTakeCard = new URL("file", null, pathSounds + "takeCard.wav");
            final URL urlShuffleCards = new URL("file", null, pathSounds + "shuffleCards.wav");
            final URL urlLayCards = new URL("file", null, pathSounds + "layCards.wav");
            final URL urlButton = new URL("file", null, pathSounds + "button.wav");
            final URL urlToggle = new URL("file", null, pathSounds + "toggle.wav");
			this.setSoundTakeCard(Applet.newAudioClip(urlTakeCard));
			this.setSoundShuffleCards(Applet.newAudioClip(urlShuffleCards));
			this.setSoundLayCards(Applet.newAudioClip(urlLayCards));
			this.setSoundButton(Applet.newAudioClip(urlButton));
			this.setSoundToggle(Applet.newAudioClip(urlToggle));
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public AudioClip getSoundTakeCard() {
		return this.soundTakeCard;
	}

	public void setSoundTakeCard(final AudioClip soundTakeCard) {
		this.soundTakeCard = soundTakeCard;
	}

	public AudioClip getSoundShuffleCards() {
		return this.soundShuffleCards;
	}

	public void setSoundShuffleCards(final AudioClip soundShuffleCards) {
		this.soundShuffleCards = soundShuffleCards;
	}

	public AudioClip getSoundLayCards() {
		return this.soundLayCards;
	}

	public void setSoundLayCards(final AudioClip soundLayCards) {
		this.soundLayCards = soundLayCards;
	}

	public AudioClip getSoundButton() {
		return this.soundButton;
	}

	public void setSoundButton(final AudioClip soundButton) {
		this.soundButton = soundButton;
	}

	public AudioClip getSoundToggle() {
		return this.soundToggle;
	}

	public void setSoundToggle(final AudioClip soundToggle) {
		this.soundToggle = soundToggle;
	}
}
