package ru.itis.html.generator;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

/**
 * 30.10.2020
 * 46. Annotations
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes(value = {"ru.itis.html.generator.HtmlForm"})
public class HtmlProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // получить типы с аннотацией HtmlForm
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);
//        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Count of classes: " + annotatedElements.size());
        for (Element element : annotatedElements) {
            // получаем путь с class-файлам
            String path = HtmlProcessor.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            // создадим путь к html-файлу
            // User.class -> User.html
            path = path.substring(1) + element.getSimpleName().toString() + ".html";
            // формируем путь для записи данных
            Path out = Paths.get(path);

            try {
//                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "PATH " + out.toString());
                BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile()));
                HtmlForm annotation = element.getAnnotation(HtmlForm.class);
                writer.write("<form action='" + annotation.action() +
                        " method='" + annotation.method() + "'/>");
                writer.close();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return true;
    }
}
