package zipper;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



import org.junit.Test;

public class ArgZipTest {
    @Test
    public void parse() {
    ArgZip argZip = new ArgZip(new String[]{"-d=C:\\Projects\\job4j_design", "-e=xml", "-o=somefile.zip"});
        assertThat(argZip.argsValues().get("d"), is("C:\\Projects\\job4j_design"));
        assertThat(argZip.argsValues().get("e"), is("xml"));
        assertThat(argZip.argsValues().get("o"), is("somefile.zip"));
        assertTrue(argZip.valid());
        assertThat(argZip.directory(), is("C:\\Projects\\job4j_design"));
        assertThat(argZip.exclude(), is("xml"));
        assertThat(argZip.output(), is("somefile.zip"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inValid() {
        ArgZip argZipNoValid = new ArgZip(new String[]{"-d=C:\\Projects\\job4j_design", "-e=xml"});
        argZipNoValid.valid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgZip tst = new ArgZip(new String[] {"-z="});
        tst.argsValues().get("z");
    }
}

