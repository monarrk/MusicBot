public class Note(i: Int, list: List<String> = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")) {
	/// Starting at A0 and increasing a half step
	val base: Int
	val notes: List<String>
	
	fun get_base(): Int = this.base

	/// Get the name of the note
	fun name(): String = notes[this.base % 12]

	init {
		this.base = i
		this.notes = list
	}
}
