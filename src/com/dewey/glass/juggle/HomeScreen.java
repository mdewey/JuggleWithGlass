package com.dewey.glass.juggle;

import android.content.Context;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.KeyEvent;
import android.widget.TextView;

import com.google.android.glass.app.Card;
import com.google.android.glass.media.Sounds;

public class HomeScreen extends Activity {

	private Card _card;
	private View _cardView;
	private TextView _statusTextView;

	private TextToSpeech _speech;

	private Context _context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_card = new Card(_context);
		_card.setText("Welcome to juggle with glass. ");
		_cardView = _card.toView();
		setContentView(_cardView);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch(keyCode){
		case KeyEvent.KEYCODE_DPAD_CENTER:
		case KeyEvent.KEYCODE_ENTER:
			AudioManager audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			audio.playSoundEffect(Sounds.TAP);
			
			_speech.speak("I like that.", TextToSpeech.QUEUE_FLUSH, null);
			
			return true;
			
		default:
			return super.onKeyDown(keyCode, event);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}
}
