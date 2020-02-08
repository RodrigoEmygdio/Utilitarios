package org.emygdio.utilitarios.cast;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Cast<T> {

    private Map<String, Function<Class<T>, T>> retornosPadroes = new HashMap<>();

    private Cast(){
        inicializa();
    }

    public static <T> Cast<T> newInstance() {
        return  new Cast<T>();
    }

    public  T castValor(Optional valor, Class<T> integerClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if(valor.isPresent()){
            return (T) valor.get();
        }
        return (T) retornosPadroes.get(integerClass.getName()).apply(integerClass);

    }

    private void inicializa(){
        retornosPadroes.put("java.lang.String", classes -> {
            try {
                return (T) Arrays.stream(classes.getConstructors()).filter(constructor -> constructor.getParameterCount() == 0).findFirst().get().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
              throw  new RuntimeException(e.getMessage()) ;
            }
        });

        retornosPadroes.put("java.lang.Integer", classes -> {
            try {
                return (T) Arrays.stream(classes.getConstructors()).filter(constructor -> constructor.getParameterCount() == 0 && constructor.getParameterTypes()[0].getName().equals("java.lang.Integer")).findFirst().get().newInstance(0);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw  new RuntimeException(e.getMessage()) ;
            }
        });

    }
}
