package main.java.listeners;

import java.util.EventListener;

public interface TableButtonListener extends EventListener {
    void tableButtonClicked( Long id );
}
