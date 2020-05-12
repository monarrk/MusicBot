public class Chord(max: Int = 3) {
	/// Base number starting at A0 and going up one half step (1, would be A#0, 7 Eb0, etc)
	val base: Int

	/// Chord modifiers
	val mods: MutableSet<Mods>

	/// Actual notes in the chord
	val notes: MutableList<Note>
	
	/// Optionally add a mod to chord
	fun add_mod(mod: Mods) {
		// 50% chance of applying mod
		if ((0..1).random() == 0) {
			this.mods.add(mod)
		}
	}

	/// Generate notes
	fun notegen(): MutableList<Note> {
		val lst: MutableList<Note> = mutableListOf()

		// First note (easy peasy)
		lst.add(Note(this.base))

		// Third
		var third = base + 4
		if (mods.contains(Mods.MINOR)) {
			third = third - 1
		}
		lst.add(Note(third))

		// Fifth
		lst.add(Note(base + 7))

		// Seventh
		var seven = base + 12
		if (mods.contains(Mods.SEVEN)) {
			seven = seven - 2
		} else if (mods.contains(Mods.MAJSEVEN)) {
			seven = seven - 1
		}
		lst.add(Note(seven))

		return lst
	}

	// Getters
	fun get_base(): Int = this.base
	fun get_mods(): MutableSet<Mods> = this.mods
	fun get_notes(): MutableList<Note> = this.notes

	/// Dump information
	fun dump(): String {
		// Collect note names
		val n: MutableList<String> = mutableListOf()
		this.get_notes().forEach {
			n.add(it.name())
		}

		return "base: ${this.get_base()}, mods: ${this.get_mods()}, notes: $n}"
	}

	/// Generate a chord
	init {
		// Give ourselves a range of octaves
		base = (0..(max * 12)).random()
		mods = mutableSetOf()

		// Generate mods
		add_mod(Mods.MINOR)
		add_mod(Mods.SEVEN)
		add_mod(Mods.MAJSEVEN)

		notes = notegen()
	}
}

enum class Mods {
	MINOR,
	SEVEN,
	MAJSEVEN,
}
