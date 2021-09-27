package fr.jabbytechs.eclipse.news.content;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Les nouveautés Eclipse IDE")
public class Talk {

	@Order(30)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration générale de l'UX")
	class GeneralUXImprovements {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Création d'un fichier avec le chemin")
		@Test
		void creerClasseWithCodeSmell() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					- Ctrl+N > File > Put a name with / in the name
					Création d'un fichier Java avec un chemin
					Créer une classe `AllKinfOfCode`
					""");
		}
	
		@Order(20)
		@DisplayName("Amélioration du Ctrl+3")
		@Test
		void findAction() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Ctrl+3 > Montrer les différentes sections :

					- previous choice
					- Editors/ Views
					- Command (action)
					- Préférences
					- Help
					""");
		}

		@Order(50)
		@DisplayName("Préférences pour la dernière page de recherche")
		@Test
		void recherche() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Montrer qu'il y a une préférence qui permet de conserver la dernière page de recherche.
					Activée par défaut.

					Montrer ce que ça donne.

					Parler de la recherche Ctrl+Alt+Shift+L.
					Parler du fait que l'on a maintenant une indication que la recherche a atteind la limite.
					""");
		}

		@Order(60)
		@DisplayName("Horizontal scroll avec gesture ou Shift + Scroll")
		@Test
		void horizontalScroll() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Ouvrir un éditeur de code.
					Réduire l'affichage.
					Montrer le scroll avec le gesture.

					Vraiment super pratique.
					""");
		}
	}

	@Order(40)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration UX autour de Java")
	class JavaUX {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Nouvelle option de `Parallel Search` activée par défaut")
		@Test
		void parallelSearch() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Alors j'ai une gross habitude du search full text.
					Mais la recherche onglet Java améliore ses performances sur des machines récentes.

					Ctrl+3 > Java Search
					""");
		}

		@Order(20)
		@DisplayName("Nouvelle configuration par défaut sur les filtres de types")
		@Test
		void defaultTypeFilter() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Ctrl+3 > Type filter

					Montrer la liste.

					Aller dans le code.
					Montrer que l'on ne voit plus `java.awt.List`

					Impacte : Open Type dialog, content assist, quick fix, and organize imports

					N'impacte pas la vue `Type hierarchy` ni le `Package Explorer`.

					Disclaimer : si vous avez besoin d'utiliser certains types, désactiver le filtre sur le workspace.
					""");
		}
	}

	@Order(50)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration de l'éditeur Java")
	class JavaEditor {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Subword code completion")
		@Test
		void subwordCodeCompletion() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans la classe `AllKindOfCode`

					Prendre la méthode `subwordCodeCompletion`

					Décommenter le code et montrer la complétion avec `all`

					""");
		}

		@Order(20)
		@DisplayName("Subtype code completion")
		@Test
		void subtypeCodeCompletion() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans la classe `AllKindOfCode`

					Prendre la méthode `subtypeCodeCompletion`

					Décommenter le code et montrer la complétion avec `L`

					Montrer également le support complet du substring / subword matches pour les types
					`linkedqueue`

					""");
		}

		@Order(30)
		@DisplayName("Completion overwrites")
		@Test
		void completionOverwrites() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente,
					"""

							Aller dans la classe `AllKindOfCode`

							Prendre la méthode `completionOverwrites`

							Décommenter le code et montrer le complétion overwrite.
							Pour reproduire l'ancien comportement, appuyer sur Ctrl en même temps que l'on sélectionne la valeur.
							""");
		}

		@Order(40)
		@DisplayName("Inserer le paramètre deviné")
		@Test
		void insertBestGuessedParameters() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans la classe `AllKindOfCode`

					Prendre la méthode `insertBestGuessedParameters`

					Décommenter le code.
					Lancer la complétion après `insertBestGuessedParametersOtherMethod`
					""");
		}

		@Order(50)
		@DisplayName("Menu pour le rawpaste")
		@Test
		void menuRawPaste() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					""");
		}
	}

	@Order(60)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Quick Assist")
	class QuickAssist {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Surround with Try with resources")
		@Test
		void surroundWithTryWithResources() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans la classe `AllKindOfCode`

					Prendre la méthode `surroundWithTryWithResources`

					Décommenter le code, sélectionner les 2 premières lignes.
					Ctrl+1 > Surround with try with resources

					""");
		}

		@Order(20)
		@DisplayName("Create Try with Resources")
		@Test
		void createTryWithResources() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans la classe `AllKindOfCode`

					Prendre la méthode `createTryWithResources`

					Ctrl+1 > Assign to new
					""");
		}

		@Order(40)
		@DisplayName("Plusieurs quifixes pour les sealed class")
		@Test
		void sealedClassQuicfixes() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """

					Aller dans l'interface `Shape`

					Décommenter > Ctrl+1 sur Triangle

					Aller dans la classe Circle, décommenter >
						- Ctrl + 1 sur Circle
						- Ctrl + 1 sur Shape
					""");
		}
	}

	@Order(70)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("71 nouveaux cleanups")
	class CleanUps {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Afficher les cleanups")
		@Test
		void afficherCleanup() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Ouvrir `AllKindOfBadCode`

					Alt+Shift+S > U

					Montrer la fenêtre de cleanup

					Configurer un profil custom :
						- Regexp compile
						- Add elements in collections without loop
						- Java Features
						- valueOf
						- Create array with curly when possible
						- Use StringBuilder instead of StringBuffer clean up
					""");
		}
	}

	@Order(80)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Debug")
	class Debug {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Amélioration du debug")
		@Test
		void ameliorationDebug() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						Aller dans la classe `ConversionService`

						Placer un point d'arrêt sur la méthode `getAvailableConversion`

						Lancer l'application (Main.java) en mode debug

						Montrer :
						- inspecter les données des variables dans la pile d'appel (cf. ConversionResource)
						- inspecter les éléments dans la chaîne d'appel (cf. contenu predicate)
						- inspecter le predicate
						- mettre en place un tracepoint (évite de polluer votre code)
						- Helpful NPE (cf. debug configuration)
					""");
		}

		@Order(20)
		@DisplayName("Vue variables")
		@Test
		void vueVariables() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Actual type in variable view
							=> enlever les colonnes
							=> activer `Show type names`
					""");
		}

	}

	@Order(90)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Console View")
	class ConsoleView {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Prérequis : lancer l'appli via Eclipse IDE")
		@Test
		void prerequis() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Prérequis : lancer l'application via Eclipse IDE > Main.java
					""");
		}

		@Order(20)
		@DisplayName("Synchro word wrap dans les préférences")
		@Test
		void preferencePourWordWrapParDefaut() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Ctrl + 3 > Console > Enable word wrap.

					Synchro avec ce qui est présent au clic droit dans la console.
					""");
		}

		@Order(30)
		@DisplayName("Heure de fin du process")
		@Test
		void heureArretProcess() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					Lors de l'arrêt du process, l'heure est affichée.
					""");
		}

		@Order(40)
		@DisplayName("Ctrl + K, Ctrl + Shift + K")
		@Test
		void rechercheOccurencePrecedenteOuSuivante() {
			var partiePresente = false || sectionPresente;
			assertTrue(partiePresente, """
					Une fois une recherche effectuée dans la console, on peut utiliser :

					* ctrl+K : prochaine occurence
					* ctrl+shift+k : occurence prédédente
					""");
		}

	}
	
	@Order(100)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Dark Theme")
	class DarkTheme {

		boolean sectionPresente = false;
		
		@Order(40)
		@DisplayName("Forte amélioration sous Windows")
		@Test
		void rechercheOccurencePrecedenteOuSuivante() {
			var partiePresente = false || sectionPresente;
			assertTrue(partiePresente, """
					Une fois une recherche effectuée dans la console, on peut utiliser :

					* ctrl+K : prochaine occurence
					* ctrl+shift+k : occurence prédédente
					""");
		}

	}
}