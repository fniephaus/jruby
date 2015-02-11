def m(foo:, bar:)
  foo + bar
end

def n(foo = 1, bar = 2)
  foo + bar
end

def o(foo, bar:)
    foo + bar
end

def p(a, b=2, c:)
    a + b + c
end

def q(foo:1, bar:2)
    foo + bar
end

def assert(a, b)
if a != b
    puts "error"
end
end

200.times.each do |times|
#    beginning_time = Time.now
#    (1..100_000_000).each do |i|
#        m()
#    end
#    end_time = Time.now
#    puts "Time elapsed #{(end_time - beginning_time)*1000} milliseconds"

    beginning_time = Time.now
    (1..1000000).each do |i|
        assert(n(1, 2), 3)
        assert(m(foo: 1, bar: 2), 3)
        assert(o(1, bar: 2), 3)
        assert(p(1, c:3), 6)
        assert(q(foo:1, bar:2), 3)
        assert(q(foo:1), 3)
        assert(q(), 3)
    end
    end_time = Time.now
    puts "Time elapsed #{(end_time - beginning_time)*1000} milliseconds"
end
