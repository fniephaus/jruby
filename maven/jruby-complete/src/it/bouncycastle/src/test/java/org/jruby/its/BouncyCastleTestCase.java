package org.jruby.its;

import junit.framework.TestCase;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jruby.embed.ScriptingContainer;
import org.junit.Test;

import static org.junit.Assert.*;

public class BouncyCastleTestCase {
    @Test
    public void java() {
        assertEquals("BouncyCastle Security Provider v1.47", new BouncyCastleProvider().getInfo());
    }

    @Test
    public void ruby(){
        ScriptingContainer container = new ScriptingContainer();
        container.setSelfFirstClassloader(true);
        Object result = container.parse( "require 'openssl'; Java::OrgBouncycastleJceProvider::BouncyCastleProvider.new.info").run();
        assertEquals( "BouncyCastle Security Provider v1.49", result.toString() );

        result = container.parse("JRuby.runtime.jruby_class_loader").run();
        assertEquals("org.jruby.util.SelfFirstJRubyClassLoader", result.toString().replaceFirst("@.*$", ""));
    }
}
