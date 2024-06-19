package com.badlogic.game.Screens;

import com.badlogic.game.Kring;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
    private final Kring instance;
    private final Texture backgroundImage;
    private final OrthographicCamera camera;

    private final Stage stage;
    private final Skin skin;

    public MainMenuScreen(Kring instance) {
        this.instance = instance;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800, 480);

        backgroundImage = new Texture(Gdx.files.internal("BackgroundImage.png"));

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton StartButton = new TextButton("Start Game", skin);
        TextButton ExitButton = new TextButton("Exit", skin);

        ConfigureButtons(StartButton, ExitButton);

        stage.addActor(StartButton);
        stage.addActor(ExitButton);
    }

    private void ConfigureButtons(TextButton StartButton, TextButton ExitButton) {
        float ScreenWidth = Gdx.graphics.getWidth();
        float ScreenHeight = Gdx.graphics.getHeight();

        StartButton.setSize(200, 50);
        ExitButton.setSize(200, 50);

        StartButton.setPosition((ScreenWidth - 200) / 2, ScreenHeight / 2 + 50);
        ExitButton.setPosition((ScreenWidth - 200) / 2, ScreenHeight / 2 - 50);

        StartButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                // Set the game screen to Game Screen
                dispose();
            }
        });

        ExitButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        instance.batch.setProjectionMatrix(camera.combined);

        instance.batch.begin();

        float ScreenWidth = Gdx.graphics.getWidth();
        float ScreenHeight = Gdx.graphics.getHeight();

        float AspectRatio = backgroundImage.getWidth() / (float) backgroundImage.getHeight();

        float BackgroundWidth = ScreenWidth;
        float BackgroundHeight = ScreenHeight / AspectRatio;

        if (BackgroundHeight < ScreenHeight) {
            BackgroundHeight = ScreenHeight;
            BackgroundWidth = ScreenHeight * AspectRatio;
        }

        instance.batch.draw(backgroundImage, 0, 0, BackgroundWidth, BackgroundHeight);

        instance.batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        camera.setToOrtho(false, i, i1);
        stage.getViewport().update(i, i1, true);
        ConfigureButtons((TextButton) stage.getActors().get(0), (TextButton) stage.getActors().get(1));
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        backgroundImage.dispose();
        skin.dispose();
        stage.dispose();
    }
}
