module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.entities.levels;

    opens audio;
    opens backgrounds;
    opens sprites;
}
