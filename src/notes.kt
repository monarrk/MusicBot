public class Note(i: Int, list: List<String> = listOf("D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D")) {
	/// Starting at A0 and increasing a half step
	val base: Int

	/// List of note names
	val notes: List<String>
	
	fun get_base(): Int = this.base

	/// Get the name of the note
	fun name(): String = notes[this.base % 12]

	init {
		this.base = i
		this.notes = list
	}
}
