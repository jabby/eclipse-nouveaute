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

	@Order(10)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration générale de l'UX")
	class GeneralUXImprovements {

		boolean sectionPresente = true;

		@Order(10)
		@DisplayName("Quick Search : affichage max occurrences reached")
		@Test
		void quickSearch() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
					- Ctrl+Alt+Shift+L => faire une recherche lettre `e`
					- Montrer le max reached
					""");
		}
	
		@Order(20)
		@DisplayName("Multi-sélection : c'est pas mail mais...")
		@Test
		void multiSelection() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Possibilité de faire Alt+Click pour rajouter des curseurs.
						- Ajout de commande. Elles ne sont pas mappés sur des raccourcis clavier par défaut 🙁
						- Proposition de commandes mais nécessite de virer certains raccourcis clavier existants
						-- Esc : End multi-selection
						-- Ctrl-Alt-J : Multi selection down relative to anchor selection
						-- Alt-J : Multi selection up relative to anchor selection
						-- Ctrl-Shift-Alt-J : Add all matches to multi-selection
						-- Ctrl-Alt-Shift-Up : Multi caret Up
						-- Ctrl-Alt-Shift-Down : Multi caret down
					""");
		}

		@Order(30)
		@DisplayName("Multi-sélection : ... il manque 2/3 trucs")
		@Test
		void findAction() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- le mapping de touches est pas fait par défaut
						- il n'est pas possible de faire Ctrl+Shift+Left / Ctrl+Shift+Right mais ça marche avec Shift+End / Shift-Home
						- le curseur est pas super joli, ça fait pas fini
					""");
		}
		
		@Order(40)
		@DisplayName("Explicit encoding")
		@Test
		void explicitEncoding() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- JEP 400: UTF-8 by Default : https://openjdk.org/jeps/400 
						- si pas d'encoding spécifié au démarrage d'Eclipse IDE, l'encoding par défaut des nouveaux workspace est UTF-8
						- montrer Preferences > Workspaces
						- Encoding nouveau projet UTF-8 : créer projet + montrer la conf (avec le fichier de conf)
						- Warning pour les projets sans config sur l'encoding
						- Possibilité de changer la sévérité du warning
						
						- Problème : le plugin m2e reset la préférence quand on fait un Alt+F5
					""");
		}
		
		@Order(50)
		@DisplayName("Large File Association")
		@Test
		void largeFileAssociation() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Préférence pour les large file association
						- Utile par exemple pour de gros fichiers de log
					""");
		}

		@Order(60)
		@DisplayName("Word wrap pour les éditeurs de code")
		@Test
		void horizontalScroll() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Preferences > Text Editor > Enable Word Wrap
						- j'aime pas surtout en Java
					""");
		}
	}

	@Order(20)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration UX autour de Java")
	class JavaUX {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Nouvelle configuration par défaut sur les filtres de types")
		@Test
		void defaultTypeFilter() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Ctrl+3 > Type filter
						- Montrer la liste.
						- Aller dans le code.
						- Montrer que l'on ne voit plus `java.awt.List`
						- Impacte : Open Type dialog, content assist, quick fix, and organize imports
						- N'impacte pas la vue `Type hierarchy` ni le `Package Explorer`.
						- Disclaimer : si vous avez besoin d'utiliser certains types, désactiver le filtre sur le workspace.
					""");
		}
	}

	@Order(30)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Amélioration de l'éditeur Java")
	class JavaEditor {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Menu pour le rawpaste")
		@Test
		void menuRawPaste() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Aller dans `AllKindOfCode`
						- Ctrl+Shift+Insert : pour changer le mode de collage
						- Impossible à se souvenir
						- utilisation menu raw paste
						- sinon Ctrl+3 chercher `Raw paste`
					""");
		}
		
		@Order(20)
		@DisplayName("Javadoc pour les module-info.java")
		@Test
		void moduleInfoJavadocCompletion() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Ouvrir `module-info.java`
						- Créer un module
						- Ajouter une javadoc : montrer la complétion @see, @link et @linkplain
						- Montrer le quickfix sur `ConversionResource` : changement module-info
						- Montrer le quickfix pour changer la conf classpath
					""");
		}
	}

	@Order(40)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Quick Assist")
	class QuickAssist {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Sealed class : plusieurs quifixes")
		@Test
		void sealedClassQuicfixes() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Aller dans l'interface `Shape`
						- Décommenter > Ctrl+1 sur Triangle
						- Aller dans la classe Circle, décommenter >
							- Ctrl+1 sur Circle
							- Ctrl+1 sur Shape
					""");
		}
		
		@Order(20)
		@DisplayName("Static favorites")
		@Test
		void staticFavorites() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Parler des favorites : Ctrl+3 > Favorites
						- Montrer qu'il y en a plus qu'avant
						- Montrer comment en ajouter ici 
						- Aller dans `AllKindOfCode`
						- Ctrl+1 sur `sqrt` : add static import
						- Ctrl+1 sur `import static java.lang.Math.sqrt;`
					""");
		}
		
		@Order(30)
		@DisplayName("Extract lambda body to method")
		@Test
		void extractLambdaBodyToMethod() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Aller dans `AllKindOfCode`
						- Ctrl+1 sur s.length()
					""");
		}
		
		@Order(40)
		@DisplayName("Extend Interface")
		@Test
		void extendInterface() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Aller dans `Shape`
						- Ctrl+1 : extend interface
						- Enchainer sur les autres quickfixes `Create sub type for sealed super type`
					""");
		}
	}

	@Order(50)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("20 nouveaux cleanups")
	class CleanUps {

		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("Afficher les cleanups")
		@Test
		void afficherCleanup() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Ouvrir `AllKindOfBadCode`
						- Alt+Shift+S > U
						- Montrer la fenêtre de cleanup
						- Utiliser le profile de démo
						- Préciser qu'il faut pas tout mettre d'un coup
						- Préciser qu'il est utile de passer plusieurs fois les clean-up
						- Préciser que l'on peut mettre en save action
					""");
		}
	}

	@Order(60)
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	@DisplayName("Junit")
	class JUnit {
		boolean sectionPresente = false;

		@Order(10)
		@DisplayName("")
		@Test
		void ameliorationDebug() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Plusieurs ajouts fait dans les favorites
						- Aller dans `ConversionResourceTest`
						- Lancer les tests
						- Re-run failed first
						- 
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
						- Aller dans la classe `ConversionService`
						- Placer un point d'arrêt au début de `convert`
						- Appeler l'url http://localhost:8080/convert/10/METRE/YARD
						
						Montrer :
						- inspecter les éléments dans la chaîne d'appel (cf. paramètre du passés au controller)
						- mettre en place un tracepoint dans le main Quarkus
						- le label sur les objets de debug
						- le fait que le label est repris dans les autres objets (exemple `ConversionResult`)
						- sur ConversionUnit dans vue `Variables` montrer que l'on peut aller directement à la déclaration d'un champ de l'enum
					""");
		}

		@Order(20)
		@DisplayName("Process ID")
		@Test
		void processID() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Click droit sur le process dans la vue Debug
						- Voir les properties
						- Montrer le PID
					""");
		}
		
		@Order(30)
		@DisplayName("Lambda Entry Point")
		@Test
		void vueVariables() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Mettre un point d'arrêt sur la lambda dans ConversionService#filterAvailableConversions
						- Accéder à l'url http://localhost:8080/conversions?conversionUnit=METRE
						- Le debug s'arrête sur la lambda
					""");
		}

		@Order(40)
		@DisplayName("Debug Launch Configuration")
		@Test
		void debugLaunchConfiguration() {
			var partiePresente = false;
			assertTrue(partiePresente || sectionPresente, """
						- Paramètre pour utiliser directement l'encoding du système
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
		@DisplayName("Support for ANSI escape codes in Console")
		@Test
		void ansiCharacters() {
			var partiePresente = false || sectionPresente;
			assertTrue(partiePresente, """
						- Lancer l'application Quarkus
						- Montrer la coloration 
						- Montrer la préférence avec le choix des couleurs
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
						- Retour au slide, montrer les quelques rares améliorations
						- C'est pas mieux sous Linux ???
					""");
		}

	}
}