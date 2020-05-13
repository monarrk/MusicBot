import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;

fun generate_tone(hz: Double, msecs: Int, volume: Int) {
	val frequency: Float = 44100.toFloat();
	var buf: ByteArray = ByteArray(2)
	var af: AudioFormat = AudioFormat(frequency, 8, 1, true, false);

	var sdl = AudioSystem.getSourceDataLine(af)
	sdl.open(af)
	sdl.start()
	
	var i = 0
	while (i < msecs * frequency / 1000) {
		val angle = i / (frequency / hz) * 2.0 * Math.PI
		buf[0] = (Math.sin(angle) * volume).toByte()
		sdl.write(buf, 0, 1)

		i = i + 1
	}

	sdl.drain()
	sdl.flush()
	sdl.stop()
	sdl.close()
}
