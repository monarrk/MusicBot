import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;

fun generate_tone(hz: Int, msecs: Int, volume: Int) {
	val frequency: Float = 44100.toFloat();
	var buf: ByteArray = ByteArray(2)
	var af: AudioFormat = AudioFormat(frequency, 8, 2, true, false);

	var sdl = AudioSystem.getSourceDataLine(af)
	sdl.open(af)
	sdl.start()
	
	var i = 0
	while (i < msecs * frequency / 1000) {
		val angle = i / (frequency / hz) * 2.0 * Math.PI
		buf[0] = (Math.sin(angle)*volume).toByte()
		val angle2 = i / (frequency / hz) * 2.0 * Math.PI
		buf[1] = (Math.sin(2 * angle2) * volume * 0.6).toByte()
		sdl.write(buf, 0, 2)

		i = i + 1
	}
	sdl.drain()
	sdl.stop()
	sdl.close()
}
