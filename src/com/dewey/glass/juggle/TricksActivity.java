package com.dewey.glass.juggle;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.glass.app.Card;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.timeline.LiveCard;

public class TricksActivity extends Activity {

	private Card _card;
	private View _cardView;
	private TextView _statusTextView;
	private TextToSpeech _speech;
	private Context _context = this;

	private LiveCard mLiveCard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_card = new Card(_context);
		_card.setText("Time for tricks. ");
		_card.setFootnote("Tap to start");
		_cardView = _card.toView();
		setContentView(_cardView);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
		case KeyEvent.KEYCODE_ENTER:
			AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			audio.playSoundEffect(Sounds.SUCCESS);
			_card = new Card(_context);
			_card.setText("Juggle this: \n" + "   trick goes here \n");
			_card.setFootnote(" Tap for next trick");
			_cardView = _card.toView();
			setContentView(_cardView);
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
