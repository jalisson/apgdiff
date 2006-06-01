/*
 * $CVSHeader$
 */
package cz.startnet.utils.pgdiff;

import java.util.HashMap;
import java.util.Map;


/**
 * Stores schema information.
 *
 * @author fordfrog
 * @version $CVSHeader$
 */
public class PgSchema {
    /**
     * Map of sequence names and sequence definitions.
     */
    private Map<String, PgSequence> sequences =
        new HashMap<String, PgSequence>();

    /**
     * Map of table names and table definitions.
     */
    private Map<String, PgTable> tables = new HashMap<String, PgTable>();

    /**
     * Creates a new instance of PgSchema.
     */
    public PgSchema() {
    }

    /**
     * Returns sequence with given name. If the sequence exists in the
     * {@link #sequences sequences} then the existing sequence is returned
     * otherwise new sequence is created.
     *
     * @param name name of the sequence
     *
     * @return existing or new sequence
     */
    public PgSequence getSequence(String name) {
        PgSequence sequence = null;

        if (sequences.containsKey(name)) {
            sequence = sequences.get(name);
        } else {
            sequence = new PgSequence(name);
            sequences.put(name, sequence);
        }

        return sequence;
    }

    /**
     * Returns map of all sequences.
     *
     * @return map of all sequences
     */
    public Map<String, PgSequence> getSequences() {
        return sequences;
    }

    /**
     * Returns table with given name. If the table exists in the {@link
     * #tables tables} then the existing table is returned otherwise new table
     * is created.
     *
     * @param name name of the table
     *
     * @return existing or new table
     */
    public PgTable getTable(String name) {
        PgTable table = null;

        if (tables.containsKey(name)) {
            table = tables.get(name);
        } else {
            table = new PgTable(name);
            tables.put(name, table);
        }

        return table;
    }

    /**
     * Returns map of all tables.
     *
     * @return map of all tables
     */
    public Map<String, PgTable> getTables() {
        return tables;
    }
}
