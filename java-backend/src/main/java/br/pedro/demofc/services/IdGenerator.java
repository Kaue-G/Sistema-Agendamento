package br.pedro.demofc.services;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;

@SuppressWarnings("unchecked")
public class IdGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        String query = String.format("SELECT %s FROM %s",
                session.getEntityPersister(o.getClass().getName(),o).getIdentifierPropertyName(),o.getClass().getName());

        LocalDate date = LocalDate.now();
        int lower = date.getMonth().getValue();
        int higher = date.getDayOfMonth();
        int key = new Random().nextInt(higher*2) + lower;

        long max = session.createQuery(query).stream()
                .mapToLong(id -> Long.parseLong(id.toString().replaceAll(".+" + prefix,"")))
                .max()
                .orElse(0L);

        return key +  prefix + (max + 1);
    }
}
