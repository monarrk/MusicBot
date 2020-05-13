public class Note(i: Int, min: Int = 10, max: Int = 300, list: List<String> = listOf("A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A")) {
	/// Starting at notes[-1] and increasing a half step
	val base: Int

	/// List of note names
	val notes: List<String>

	/// Length in msecs of the note
	val len: Int

	/// Is this note a rest?
	val rest: Boolean
	
	// Getters
	fun get_base(): Int = this.base
	fun get_len(): Int = this.len
	fun is_rest(): Boolean = this.rest

	/// Get the name of the note
	fun name(): String = notes[(this.notes.count() - 1) - (this.base % 12)]

	init {
		this.base = i
		this.notes = list
		this.len = (min..max).random()
		
		rest = if (((0..10).random()) < 2) true else false
	}
}
