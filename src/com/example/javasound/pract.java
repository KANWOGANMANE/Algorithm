package com.example.javasound;

import javax.sound.midi.*;

public class pract {

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        play();
    }

    public static void play() throws MidiUnavailableException, InvalidMidiDataException {
        //1.取得sequencer、然后打开
        Sequencer player = MidiSystem.getSequencer();
        player.open();

        //2.
        Sequence seq = new Sequence(Sequence.PPQ,4);

        //3.取得Track
        Track track = seq.createTrack();

        //4.对Track加入几个MidiEvent
        ShortMessage a = new ShortMessage();
        a.setMessage(144,1,44,100);
        MidiEvent eventon = new MidiEvent(a,1); //事件开始
        track.add(eventon);

        ShortMessage b = new ShortMessage();
        b.setMessage(128,1,44,100);
        MidiEvent eventoff = new MidiEvent(a,5); //事件结束
        track.add(eventoff);

        player.setSequence(seq);
        player.start();
    }
}
