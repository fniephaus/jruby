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

def r(a, b=2, c=3, d:, e:5, f:)
    a+b+c+d+e+f
end

def s(a, b=2, c:, d:, **rest)
    a+b+c+d+rest[:e]
    #rest[:e]
end

def t(**r)
    r[:a]+r[:b]
end

def u(a, b)
    a + b[:a] + b[:b]
end

def assert(a, b)
if a != b
    puts "error: " + a.to_s + "!=" + b.to_s
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
        assert(m({foo: 1, bar:2}), 3)
        assert(o(1, bar: 2), 3)
        assert(o(1, {bar:2}), 3)
        assert(p(1, c:3), 6)
        assert(q(foo:1, bar:2), 3)
        assert(q(foo:1), 3)
        assert(q(), 3)
        assert(r(1,f:6,d:4), 21)
        assert(s(1,e:5, f:6,d:4,c:3), 15)
        assert(t(a:1, b:2, c:3), 3)
        assert(u(1, {a: 2, b: 3}), 6)
    end
    end_time = Time.now
    puts "Time elapsed #{(end_time - beginning_time)*1000} milliseconds"
end
