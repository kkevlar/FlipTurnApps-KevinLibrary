package com.flipturnapps.kevinLibrary.sound;
import javax.sound.midi.*;
public class Piano
{
	private Sequencer player;
	private Sequence seq;
	private Track track;
	private int channel;
	public Piano(int chan)
	{
		try {
			player = MidiSystem.getSequencer();
			seq = new Sequence(Sequence.PPQ, 4);
			track = seq.createTrack();
			channel = chan;
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Piano(int chan, int bpm)
	{
		try {
			player = MidiSystem.getSequencer();
			seq = new Sequence(Sequence.PPQ, bpm);
			track = seq.createTrack();
			channel = chan;
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Piano()
	{
		try {
			player = MidiSystem.getSequencer();
			seq = new Sequence(Sequence.PPQ, 4);
			track = seq.createTrack();
			channel = 0;
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void addNote(int note, int beat, int length, int velocity)
	{
		ShortMessage a = new ShortMessage();
		ShortMessage b = new ShortMessage();
		MidiEvent c = null;
		MidiEvent d = null;
		try {
			a.setMessage(144, channel, note, velocity);
			b.setMessage(128, channel, note, velocity);
			c = new MidiEvent(a,beat);
			d = new MidiEvent(b,beat + length);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		track.add(c);
		track.add(d);

	}
	public void addNote(int note, int beat, int length)
	{
		this.addNote(note, beat, length, 100);

	}
	public void addNote(int note, int beat)
	{
		this.addNote(note, beat, 1);

	}
	public void play()
	{
		try {
			player.open();
		} catch (MidiUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			player.setSequence(seq);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.start();
	}
}
