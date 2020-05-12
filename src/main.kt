fun gen_chords(): List<Chord> {
	val lst: MutableList<Chord> = mutableListOf()
	for (i in 0..((0..30).random())) {
		lst.add(Chord())
	}
	return lst.toList()
}

fun semitone_to_hz(t: Int): Int = (Math.exp(t * (Math.log(Math.pow(2.toDouble(), (1.toDouble() / 12))))) * 50).toInt()

fun main() {
	val chords = gen_chords()

	for (c in chords) {
		println(c.dump())
		val notes = c.get_notes()
		for (n in notes) {
			val note = (notes[(0..notes.count() - 1).random()])
			val st = note.get_base()
			println("name: ${note.name()}, st: $st, hz: ${semitone_to_hz(st)}")
			generate_tone(semitone_to_hz(st) / 10, c.get_len() / 4, 500)
		}
	}
}
