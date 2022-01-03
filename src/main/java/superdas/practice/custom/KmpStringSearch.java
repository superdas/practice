package superdas.practice.custom;

import java.util.Random;

class KmpStringSearch {
  public static void main(String[] args) {
    System.out.println("superdas.practice.custom.KmpStringSearch");
    String text = createText();
    find("pups", text);
  }

  // TODO:
  static void find(String input, String text) {
    System.out.println(String.format("Finding \"%s\" in text...", input));

    // Find the position of the next instance of the first character.
    char firstCharacter = input.charAt(0);
    int incrementToNextFirstCharacter = input.length();
    for (int i = 1; i < input.length(); i++) {
      if (firstCharacter == input.charAt(i)) {
        incrementToNextFirstCharacter = i;
        break;
      }
    }
    
    int i = 0;
    while (i < text.length()) {
      boolean match = true;

      for (int j = 0; j < input.length(); j++) {
        if (input.charAt(j) == text.charAt(i + j)) {
          continue;
        } else {
          match = false;

          if (j == 0) {
            i++;
          } else if (j >= incrementToNextFirstCharacter) {
            i += incrementToNextFirstCharacter;
            System.out.println(String.format("  >> [Optimization] Skipping %d characters to next match of first character...", incrementToNextFirstCharacter));
          } else {
            i += j;
            System.out.println(String.format("  >> [Optimization] Skipping %d characters that do NOT include the first character...", j));
          }

          break;
        }
      }
      
      if (match) {
        System.out.println(String.format("Match found at position %d.", i));
        System.out.println(String.format("  >> [Optimization] Skipping %d characters that can't match the first character...", incrementToNextFirstCharacter));
        i += incrementToNextFirstCharacter;
      }
    }
  }

  static String createText() {
    System.out.println("Creating text...");

    String[] words = new String[] {
      "panda", "puppy", "baba", "bear", "papa", "quochaloo", "pups", "fluffs"
    };
    int numWords = 20;

    System.out.println(String.format("Choosing %d words from dictionary...", numWords));
    StringBuilder textBuilder = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < numWords; i++) {
      textBuilder.append(words[random.nextInt(words.length)]);
      textBuilder.append(" ");
    }

    String text = textBuilder.toString();
    System.out.println("text {");
    System.out.println(text);
    System.out.println("} // text");

    return text;
  }
}
