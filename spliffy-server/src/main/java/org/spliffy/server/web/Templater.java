package org.spliffy.server.web;

import com.bradmcevoy.http.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Abstraction for generating templated page content
 *
 * @author brad
 */
public interface Templater {
    void writePage(String template, Resource r, Map<String, String> params, OutputStream out) throws IOException;
}
