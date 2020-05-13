// Generate a list of random chords
fun gen_chords(): List<Chord> {
	val lst: MutableList<Chord> = mutableListOf()
	for (i in 0..((10..30).random())) {
		lst.add(Chord(max = 2, min = 0))
	}
	return lst.toList()
}

// Equation taken from https://pages.mtu.edu/~suits/NoteFreqCalcs.html
fun semitone_to_hz(t: Int): Double = 440 * Math.pow(Math.pow(2.0, (1.0 / 12.0)), -t.toDouble())

fun main() {
	// Generate chords
	val chords = gen_chords()

	for (c in chords) {
		println("${ANSI_GREEN}new chord:$ANSI_RESET ${c.dump()}")
		val notes = c.get_notes()
		for (n in notes) {
			val note = (notes[(0..notes.count() - 1).random()])
			val st = note.get_base()
			println("  :: name: ${note.name()}, st: $st, hz: ${semitone_to_hz(st)}")
			generate_tone(semitone_to_hz(st), c.get_len() / 4, 500)
		}
	}
}
