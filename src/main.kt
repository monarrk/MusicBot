fun gen_chords(): List<Chord> {
	val lst: MutableList<Chord> = mutableListOf()
	for (i in 0..((0..30).random())) {
		lst.add(Chord())
	}
	return lst.toList()
}

fun main() {
	val chords = gen_chords()

	for (c in chords) {
		val notes = c.get_notes()
		for (n in notes) {
			generate_tone(440 * (notes[(0..notes.count() - 1).random()].get_base()), c.get_len() / 4, 500)
		}
	}
}
