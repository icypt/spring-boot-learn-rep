package com.icypt.sboot.session;

public interface SessionContainerService {
    void save(SessionContainer sc);
    void update(SessionContainer sc);
    void refresh(SessionContainer sc);
    SessionContainer get(String token);
}
