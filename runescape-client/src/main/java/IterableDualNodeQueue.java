import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "Lgs;"
	)
	public DualNode sentinel;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lgs;"
	)
	DualNode head;

	public IterableDualNodeQueue() {
		this.sentinel = new DualNode(); // L: 7
		this.sentinel.previousDual = this.sentinel; // L: 11
		this.sentinel.nextDual = this.sentinel; // L: 12
	} // L: 13

	@ObfuscatedName("z")
	public void clear() {
		while (this.sentinel.previousDual != this.sentinel) { // L: 16
			this.sentinel.previousDual.removeDual(); // L: 17
		}

	} // L: 19

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lgs;)V"
	)
	public void add(DualNode var1) {
		if (var1.nextDual != null) { // L: 22
			var1.removeDual();
		}

		var1.nextDual = this.sentinel.nextDual; // L: 23
		var1.previousDual = this.sentinel; // L: 24
		var1.nextDual.previousDual = var1; // L: 25
		var1.previousDual.nextDual = var1; // L: 26
	} // L: 27

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "()Lgs;"
	)
	public DualNode removeLast() {
		DualNode var1 = this.sentinel.previousDual; // L: 38
		if (var1 == this.sentinel) {
			return null; // L: 39
		} else {
			var1.removeDual(); // L: 40
			return var1; // L: 41
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "()Lgs;"
	)
	public DualNode last() {
		return this.previousOrLast((DualNode)null); // L: 45
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(Lgs;)Lgs;"
	)
	DualNode previousOrLast(DualNode var1) {
		DualNode var2;
		if (var1 == null) { // L: 50
			var2 = this.sentinel.previousDual;
		} else {
			var2 = var1; // L: 51
		}

		if (var2 == this.sentinel) { // L: 52
			this.head = null; // L: 53
			return null; // L: 54
		} else {
			this.head = var2.previousDual; // L: 56
			return var2; // L: 57
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "()Lgs;"
	)
	public DualNode previous() {
		DualNode var1 = this.head; // L: 61
		if (var1 == this.sentinel) { // L: 62
			this.head = null; // L: 63
			return null; // L: 64
		} else {
			this.head = var1.previousDual; // L: 66
			return var1; // L: 67
		}
	}

	public Iterator iterator() {
		return new IterableDualNodeQueueIterator(this); // L: 71
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lgs;Lgs;)V"
	)
	public static void DualNodeDeque_addBefore(DualNode var0, DualNode var1) {
		if (var0.nextDual != null) { // L: 30
			var0.removeDual();
		}

		var0.nextDual = var1; // L: 31
		var0.previousDual = var1.previousDual; // L: 32
		var0.nextDual.previousDual = var0; // L: 33
		var0.previousDual.nextDual = var0; // L: 34
	} // L: 35
}
