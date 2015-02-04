/*
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved. This
 * code is released under a tri EPL/GPL/LGPL license. You can use it,
 * redistribute it and/or modify it under the terms of the:
 *
 * Eclipse Public License version 1.0
 * GNU General Public License version 2
 * GNU Lesser General Public License version 2.1
 */
package org.jruby.truffle.nodes.methods.arguments;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.BranchProfile;
import com.oracle.truffle.api.utilities.ValueProfile;

import org.jruby.truffle.nodes.RubyNode;
import org.jruby.truffle.runtime.RubyArguments;
import org.jruby.truffle.runtime.RubyContext;
import org.jruby.truffle.runtime.core.RubyHash;
import org.jruby.truffle.runtime.hash.HashOperations;
import org.jruby.truffle.runtime.hash.KeyValue;

public class ReadKeywordArgumentNode extends RubyNode {

    private final int minimum;
    private final String name;
    private final int kwIndex;
    private final ValueProfile argumentValueProfile = ValueProfile.createPrimitiveProfile();
    
    @Child private RubyNode defaultValue;

    public ReadKeywordArgumentNode(RubyContext context, SourceSection sourceSection, int minimum, String name, RubyNode defaultValue, int kwIndex) {
        super(context, sourceSection);
        this.minimum = minimum;
        this.name = name;
        this.defaultValue = defaultValue;
        this.kwIndex = kwIndex;
    }

    @Override
    public Object execute(VirtualFrame frame) {
    	return 12;
    	//return argumentValueProfile.profile(RubyArguments.getOptimizedKeywordArgument(frame.getArguments(), kwIndex));
    }

}
