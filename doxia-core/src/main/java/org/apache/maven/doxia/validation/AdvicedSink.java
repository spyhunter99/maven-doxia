/*
 *  Copyright 2005 Juan F. Codagnone <juam at users dot sourceforge dot net>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.maven.doxia.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.validation.advices.MethodBeforeAdvice;


/**
 * Sink that can act as proxy of other sinks and run some advices
 * <p/>
 * This class can be generated on run time, but that would lead to depend on
 * more dependencies.
 *
 * @author Juan F. Codagnone (autogenerated)
 * @since Nov 6, 2005
 */
public class AdvicedSink implements Sink
{
    private final MethodBeforeAdvice [] advices;
    private final Sink target;

    public AdvicedSink( final MethodBeforeAdvice [] advices, final Sink target )
    {
        if ( advices == null || target == null )
        {
            throw new IllegalArgumentException();
        }
        for ( int i = 0; i < advices.length; i++ )
        {
            if ( advices[i] == null )
            {
                throw new IllegalArgumentException( "advices can't be null" );
            }

        }
        this.advices = advices;
        this.target = target;
    }

    private static boolean loaded = false;

    private void load()
    {
        if ( !loaded )
        {
            loaded = true;
            try
            {
                realload();
            }
            catch ( Exception e )
            {
                throw new RuntimeException( e );
            }
        }
    }


    private void advice( final Method method,
                         final Object[] args, final Object target )
    {

        for ( int i = 0; i < advices.length; i++ )
        {
            try
            {
                advices[i].before( method, args, target );
            }
            catch ( RuntimeException e )
            {
                throw e;
            }
            catch ( Throwable e )
            {
                throw new RuntimeException( e );
            }
        }
        try
        {
            method.invoke( target, args );
        }
        catch ( IllegalAccessException e )
        {
            throw new RuntimeException( e );
        }
        catch ( InvocationTargetException e )
        {
            Throwable cause = e.getCause();
            if ( cause != null )
            {
                if ( cause instanceof RuntimeException )
                {
                    throw (RuntimeException) cause;
                }
                else
                {
                    throw new RuntimeException( cause );
                }
            }
            throw new RuntimeException( e );
        }
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#head()
     */
    public final void head()
    {
        load();
        advice( M_HEAD, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#head_()
     */
    public final void head_()
    {
        load();
        advice( M_HEAD_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#body()
     */
    public final void body()
    {
        load();
        advice( M_BODY, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#body_()
     */
    public final void body_()
    {
        load();
        advice( M_BODY_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section1()
     */
    public final void section1()
    {
        load();
        advice( M_SECTION1, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section1_()
     */
    public final void section1_()
    {
        load();
        advice( M_SECTION1_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section2()
     */
    public final void section2()
    {
        load();
        advice( M_SECTION2, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section2_()
     */
    public final void section2_()
    {
        load();
        advice( M_SECTION2_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section3()
     */
    public final void section3()
    {
        load();
        advice( M_SECTION3, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section3_()
     */
    public final void section3_()
    {
        load();
        advice( M_SECTION3_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section4()
     */
    public final void section4()
    {
        load();
        advice( M_SECTION4, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section4_()
     */
    public final void section4_()
    {
        load();
        advice( M_SECTION4_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section5()
     */
    public final void section5()
    {
        load();
        advice( M_SECTION5, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#section5_()
     */
    public final void section5_()
    {
        load();
        advice( M_SECTION5_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#list()
     */
    public final void list()
    {
        load();
        advice( M_LIST, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#list_()
     */
    public final void list_()
    {
        load();
        advice( M_LIST_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#listItem()
     */
    public final void listItem()
    {
        load();
        advice( M_LISTITEM, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#listItem_()
     */
    public final void listItem_()
    {
        load();
        advice( M_LISTITEM_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#numberedList()
     */
    public final void numberedList( int i )
    {
        load();
        advice( M_NUMBEREDLIST, new Object[]{new Integer( i )}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#numberedList_()
     */
    public final void numberedList_()
    {
        load();
        advice( M_NUMBEREDLIST_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#numberedListItem()
     */
    public final void numberedListItem()
    {
        load();
        advice( M_NUMBEREDLISTITEM, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#numberedListItem_()
     */
    public final void numberedListItem_()
    {
        load();
        advice( M_NUMBEREDLISTITEM_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definitionList()
     */
    public final void definitionList()
    {
        load();
        advice( M_DEFINITIONLIST, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definitionList_()
     */
    public final void definitionList_()
    {
        load();
        advice( M_DEFINITIONLIST_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definitionListItem()
     */
    public final void definitionListItem()
    {
        load();
        advice( M_DEFINITIONLISTITEM, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definitionListItem_()
     */
    public final void definitionListItem_()
    {
        load();
        advice( M_DEFINITIONLISTITEM_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definition()
     */
    public final void definition()
    {
        load();
        advice( M_DEFINITION, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definition_()
     */
    public final void definition_()
    {
        load();
        advice( M_DEFINITION_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#figure()
     */
    public final void figure()
    {
        load();
        advice( M_FIGURE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#figure_()
     */
    public final void figure_()
    {
        load();
        advice( M_FIGURE_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#table()
     */
    public final void table()
    {
        load();
        advice( M_TABLE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#table_()
     */
    public final void table_()
    {
        load();
        advice( M_TABLE_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableRows()
     */
    public final void tableRows( int []a, boolean b )
    {
        load();
        advice( M_TABLEROWS, new Object[]{a, new Boolean( b )}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableRows_()
     */
    public final void tableRows_()
    {
        load();
        advice( M_TABLEROWS_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableRow()
     */
    public final void tableRow()
    {
        load();
        advice( M_TABLEROW, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableRow_()
     */
    public final void tableRow_()
    {
        load();
        advice( M_TABLEROW_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#title()
     */
    public final void title()
    {
        load();
        advice( M_TITLE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#title_()
     */
    public final void title_()
    {
        load();
        advice( M_TITLE_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#author()
     */
    public final void author()
    {
        load();
        advice( M_AUTHOR, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#author_()
     */
    public final void author_()
    {
        load();
        advice( M_AUTHOR_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#date()
     */
    public final void date()
    {
        load();
        advice( M_DATE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#date_()
     */
    public final void date_()
    {
        load();
        advice( M_DATE_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle()
     */
    public final void sectionTitle()
    {
        load();
        advice( M_SECTIONTITLE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle_()
     */
    public final void sectionTitle_()
    {
        load();
        advice( M_SECTIONTITLE_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle1()
     */
    public final void sectionTitle1()
    {
        load();
        advice( M_SECTIONTITLE1, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle1_()
     */
    public final void sectionTitle1_()
    {
        load();
        advice( M_SECTIONTITLE1_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle2()
     */
    public final void sectionTitle2()
    {
        load();
        advice( M_SECTIONTITLE2, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle2_()
     */
    public final void sectionTitle2_()
    {
        load();
        advice( M_SECTIONTITLE2_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle3()
     */
    public final void sectionTitle3()
    {
        load();
        advice( M_SECTIONTITLE3, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle3_()
     */
    public final void sectionTitle3_()
    {
        load();
        advice( M_SECTIONTITLE3_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle4()
     */
    public final void sectionTitle4()
    {
        load();
        advice( M_SECTIONTITLE4, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle4_()
     */
    public final void sectionTitle4_()
    {
        load();
        advice( M_SECTIONTITLE4_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle5()
     */
    public final void sectionTitle5()
    {
        load();
        advice( M_SECTIONTITLE5, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#sectionTitle5_()
     */
    public final void sectionTitle5_()
    {
        load();
        advice( M_SECTIONTITLE5_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#paragraph()
     */
    public final void paragraph()
    {
        load();
        advice( M_PARAGRAPH, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#paragraph_()
     */
    public final void paragraph_()
    {
        load();
        advice( M_PARAGRAPH_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#verbatim()
     */
    public final void verbatim( boolean b )
    {
        load();
        advice( M_VERBATIM, new Object[]{new Boolean( b )}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#verbatim_()
     */
    public final void verbatim_()
    {
        load();
        advice( M_VERBATIM_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definedTerm()
     */
    public final void definedTerm()
    {
        load();
        advice( M_DEFINEDTERM, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#definedTerm_()
     */
    public final void definedTerm_()
    {
        load();
        advice( M_DEFINEDTERM_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#figureCaption()
     */
    public final void figureCaption()
    {
        load();
        advice( M_FIGURECAPTION, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#figureCaption_()
     */
    public final void figureCaption_()
    {
        load();
        advice( M_FIGURECAPTION_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableCell()
     */
    public final void tableCell()
    {
        load();
        advice( M_TABLECELL, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableCell()
     */
    public final void tableCell( final String arg0 )
    {
        load();
        advice( M_TABLECELL, new Object[]{arg0}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableCell_()
     */
    public final void tableCell_()
    {
        load();
        advice( M_TABLECELL_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableHeaderCell()
     */
    public final void tableHeaderCell()
    {
        load();
        advice( M_TABLEHEADERCELL, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableHeaderCell()
     */
    public void tableHeaderCell( String arg0 )
    {
        load();
        advice( M_TABLEHEADERCELL, new Object[]{arg0}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableHeaderCell_()
     */
    public final void tableHeaderCell_()
    {
        load();
        advice( M_TABLEHEADERCELL_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableCaption()
     */
    public final void tableCaption()
    {
        load();
        advice( M_TABLECAPTION, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#tableCaption_()
     */
    public final void tableCaption_()
    {
        load();
        advice( M_TABLECAPTION_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#figureGraphics()
     */
    public final void figureGraphics( final String string )
    {
        load();
        advice( M_FIGUREGRAPHICS, new Object[]{string}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#horizontalRule()
     */
    public final void horizontalRule()
    {
        load();
        advice( M_HORIZONTALRULE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#pageBreak()
     */
    public final void pageBreak()
    {
        load();
        advice( M_PAGEBREAK, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#anchor()
     */
    public final void anchor( final String s )
    {
        load();
        advice( M_ANCHOR, new Object[]{s}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#anchor_()
     */
    public final void anchor_()
    {
        load();
        advice( M_ANCHOR_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#link()
     */
    public final void link( final String l )
    {
        load();
        advice( M_LINK, new Object[]{l}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#link_()
     */
    public final void link_()
    {
        load();
        advice( M_LINK_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#italic()
     */
    public final void italic()
    {
        load();
        advice( M_ITALIC, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#italic_()
     */
    public final void italic_()
    {
        load();
        advice( M_ITALIC_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#bold()
     */
    public final void bold()
    {
        load();
        advice( M_BOLD, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#bold_()
     */
    public final void bold_()
    {
        load();
        advice( M_BOLD_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#monospaced()
     */
    public final void monospaced()
    {
        load();
        advice( M_MONOSPACED, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#monospaced_()
     */
    public final void monospaced_()
    {
        load();
        advice( M_MONOSPACED_, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#lineBreak()
     */
    public final void lineBreak()
    {
        load();
        advice( M_LINEBREAK, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#nonBreakingSpace()
     */
    public final void nonBreakingSpace()
    {
        load();
        advice( M_NONBREAKINGSPACE, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#text(String)
     */
    public final void text( final String text )
    {
        load();
        advice( M_TEXT, new Object[]{text}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#rawText()
     */
    public final void rawText( final String text )
    {
        load();
        advice( M_RAWTEXT, new Object[]{text}, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#flush()
     */
    public final void flush()
    {
        load();
        advice( M_FLUSH, null, target );
    }

    /**
     * @see org.apache.maven.doxia.sink.Sink#close()
     */
    public final void close()
    {
        load();
        advice( M_CLOSE, null, target );
    }


    private static Class CLASS = Sink.class;

    private void realload() throws SecurityException, NoSuchMethodException
    {
        M_HEAD = CLASS.getMethod( "head", null );
        M_HEAD_ = CLASS.getMethod( "head_", null );
        M_BODY = CLASS.getMethod( "body", null );
        M_BODY_ = CLASS.getMethod( "body_", null );
        M_SECTION1 = CLASS.getMethod( "section1", null );
        M_SECTION1_ = CLASS.getMethod( "section1_", null );
        M_SECTION2 = CLASS.getMethod( "section2", null );
        M_SECTION2_ = CLASS.getMethod( "section2_", null );
        M_SECTION3 = CLASS.getMethod( "section3", null );
        M_SECTION3_ = CLASS.getMethod( "section3_", null );
        M_SECTION4 = CLASS.getMethod( "section4", null );
        M_SECTION4_ = CLASS.getMethod( "section4_", null );
        M_SECTION5 = CLASS.getMethod( "section5", null );
        M_SECTION5_ = CLASS.getMethod( "section5_", null );
        M_LIST = CLASS.getMethod( "list", null );
        M_LIST_ = CLASS.getMethod( "list_", null );
        M_LISTITEM = CLASS.getMethod( "listItem", null );
        M_LISTITEM_ = CLASS.getMethod( "listItem_", null );
        M_NUMBEREDLIST = CLASS.getMethod( "numberedList", new Class[]{int.class} );
        M_NUMBEREDLIST_ = CLASS.getMethod( "numberedList_", null );
        M_NUMBEREDLISTITEM = CLASS.getMethod( "numberedListItem", null );
        M_NUMBEREDLISTITEM_ = CLASS.getMethod( "numberedListItem_", null );
        M_DEFINITIONLIST = CLASS.getMethod( "definitionList", null );
        M_DEFINITIONLIST_ = CLASS.getMethod( "definitionList_", null );
        M_DEFINITIONLISTITEM = CLASS.getMethod( "definitionListItem", null );
        M_DEFINITIONLISTITEM_ = CLASS.getMethod( "definitionListItem_", null );
        M_DEFINITION = CLASS.getMethod( "definition", null );
        M_DEFINITION_ = CLASS.getMethod( "definition_", null );
        M_FIGURE = CLASS.getMethod( "figure", null );
        M_FIGURE_ = CLASS.getMethod( "figure_", null );
        M_TABLE = CLASS.getMethod( "table", null );
        M_TABLE_ = CLASS.getMethod( "table_", null );
        M_TABLEROWS = CLASS.getMethod( "tableRows", new Class[]{int[].class, boolean.class} );
        M_TABLEROWS_ = CLASS.getMethod( "tableRows_", null );
        M_TABLEROW = CLASS.getMethod( "tableRow", null );
        M_TABLEROW_ = CLASS.getMethod( "tableRow_", null );
        M_TITLE = CLASS.getMethod( "title", null );
        M_TITLE_ = CLASS.getMethod( "title_", null );
        M_AUTHOR = CLASS.getMethod( "author", null );
        M_AUTHOR_ = CLASS.getMethod( "author_", null );
        M_DATE = CLASS.getMethod( "date", null );
        M_DATE_ = CLASS.getMethod( "date_", null );
        M_SECTIONTITLE = CLASS.getMethod( "sectionTitle", null );
        M_SECTIONTITLE_ = CLASS.getMethod( "sectionTitle_", null );
        M_SECTIONTITLE1 = CLASS.getMethod( "sectionTitle1", null );
        M_SECTIONTITLE1_ = CLASS.getMethod( "sectionTitle1_", null );
        M_SECTIONTITLE2 = CLASS.getMethod( "sectionTitle2", null );
        M_SECTIONTITLE2_ = CLASS.getMethod( "sectionTitle2_", null );
        M_SECTIONTITLE3 = CLASS.getMethod( "sectionTitle3", null );
        M_SECTIONTITLE3_ = CLASS.getMethod( "sectionTitle3_", null );
        M_SECTIONTITLE4 = CLASS.getMethod( "sectionTitle4", null );
        M_SECTIONTITLE4_ = CLASS.getMethod( "sectionTitle4_", null );
        M_SECTIONTITLE5 = CLASS.getMethod( "sectionTitle5", null );
        M_SECTIONTITLE5_ = CLASS.getMethod( "sectionTitle5_", null );
        M_PARAGRAPH = CLASS.getMethod( "paragraph", null );
        M_PARAGRAPH_ = CLASS.getMethod( "paragraph_", null );
        M_VERBATIM = CLASS.getMethod( "verbatim", new Class[]{boolean.class} );
        M_VERBATIM_ = CLASS.getMethod( "verbatim_", null );
        M_DEFINEDTERM = CLASS.getMethod( "definedTerm", null );
        M_DEFINEDTERM_ = CLASS.getMethod( "definedTerm_", null );
        M_FIGURECAPTION = CLASS.getMethod( "figureCaption", null );
        M_FIGURECAPTION_ = CLASS.getMethod( "figureCaption_", null );
        M_TABLECELL = CLASS.getMethod( "tableCell", null );
        M_TABLECELL = CLASS.getMethod( "tableCell", null );
        M_TABLECELL_ = CLASS.getMethod( "tableCell_", null );
        M_TABLEHEADERCELL = CLASS.getMethod( "tableHeaderCell", null );
        M_TABLEHEADERCELL = CLASS.getMethod( "tableHeaderCell", null );
        M_TABLEHEADERCELL_ = CLASS.getMethod( "tableHeaderCell_", null );
        M_TABLECAPTION = CLASS.getMethod( "tableCaption", null );
        M_TABLECAPTION_ = CLASS.getMethod( "tableCaption_", null );
        M_FIGUREGRAPHICS = CLASS.getMethod( "figureGraphics", new Class[]{String.class} );
        M_HORIZONTALRULE = CLASS.getMethod( "horizontalRule", null );
        M_PAGEBREAK = CLASS.getMethod( "pageBreak", null );
        M_ANCHOR = CLASS.getMethod( "anchor", new Class[]{String.class} );
        M_ANCHOR_ = CLASS.getMethod( "anchor_", null );
        M_LINK = CLASS.getMethod( "link", new Class[]{String.class} );
        M_LINK_ = CLASS.getMethod( "link_", null );
        M_ITALIC = CLASS.getMethod( "italic", null );
        M_ITALIC_ = CLASS.getMethod( "italic_", null );
        M_BOLD = CLASS.getMethod( "bold", null );
        M_BOLD_ = CLASS.getMethod( "bold_", null );
        M_MONOSPACED = CLASS.getMethod( "monospaced", null );
        M_MONOSPACED_ = CLASS.getMethod( "monospaced_", null );
        M_LINEBREAK = CLASS.getMethod( "lineBreak", null );
        M_NONBREAKINGSPACE = CLASS.getMethod( "nonBreakingSpace", null );
        M_TEXT = CLASS.getMethod( "text", new Class[]{String.class} );
        M_RAWTEXT = CLASS.getMethod( "rawText", new Class[]{String.class} );
        M_FLUSH = CLASS.getMethod( "flush", null );
        M_CLOSE = CLASS.getMethod( "close", null );
    }

    /**
     * method for head
     */
    private static Method M_HEAD;
    /**
     * method for head_
     */
    private static Method M_HEAD_;
    /**
     * method for body
     */
    private static Method M_BODY;
    /**
     * method for body_
     */
    private static Method M_BODY_;
    /**
     * method for section1
     */
    private static Method M_SECTION1;
    /**
     * method for section1_
     */
    private static Method M_SECTION1_;
    /**
     * method for section2
     */
    private static Method M_SECTION2;
    /**
     * method for section2_
     */
    private static Method M_SECTION2_;
    /**
     * method for section3
     */
    private static Method M_SECTION3;
    /**
     * method for section3_
     */
    private static Method M_SECTION3_;
    /**
     * method for section4
     */
    private static Method M_SECTION4;
    /**
     * method for section4_
     */
    private static Method M_SECTION4_;
    /**
     * method for section5
     */
    private static Method M_SECTION5;
    /**
     * method for section5_
     */
    private static Method M_SECTION5_;
    /**
     * method for list
     */
    private static Method M_LIST;
    /**
     * method for list_
     */
    private static Method M_LIST_;
    /**
     * method for listItem
     */
    private static Method M_LISTITEM;
    /**
     * method for listItem_
     */
    private static Method M_LISTITEM_;
    /**
     * method for numberedList
     */
    private static Method M_NUMBEREDLIST;
    /**
     * method for numberedList_
     */
    private static Method M_NUMBEREDLIST_;
    /**
     * method for numberedListItem
     */
    private static Method M_NUMBEREDLISTITEM;
    /**
     * method for numberedListItem_
     */
    private static Method M_NUMBEREDLISTITEM_;
    /**
     * method for definitionList
     */
    private static Method M_DEFINITIONLIST;
    /**
     * method for definitionList_
     */
    private static Method M_DEFINITIONLIST_;
    /**
     * method for definitionListItem
     */
    private static Method M_DEFINITIONLISTITEM;
    /**
     * method for definitionListItem_
     */
    private static Method M_DEFINITIONLISTITEM_;
    /**
     * method for definition
     */
    private static Method M_DEFINITION;
    /**
     * method for definition_
     */
    private static Method M_DEFINITION_;
    /**
     * method for figure
     */
    private static Method M_FIGURE;
    /**
     * method for figure_
     */
    private static Method M_FIGURE_;
    /**
     * method for table
     */
    private static Method M_TABLE;
    /**
     * method for table_
     */
    private static Method M_TABLE_;
    /**
     * method for tableRows
     */
    private static Method M_TABLEROWS;
    /**
     * method for tableRows_
     */
    private static Method M_TABLEROWS_;
    /**
     * method for tableRow
     */
    private static Method M_TABLEROW;
    /**
     * method for tableRow_
     */
    private static Method M_TABLEROW_;
    /**
     * method for title
     */
    private static Method M_TITLE;
    /**
     * method for title_
     */
    private static Method M_TITLE_;
    /**
     * method for author
     */
    private static Method M_AUTHOR;
    /**
     * method for author_
     */
    private static Method M_AUTHOR_;
    /**
     * method for date
     */
    private static Method M_DATE;
    /**
     * method for date_
     */
    private static Method M_DATE_;
    /**
     * method for sectionTitle
     */
    private static Method M_SECTIONTITLE;
    /**
     * method for sectionTitle_
     */
    private static Method M_SECTIONTITLE_;
    /**
     * method for sectionTitle1
     */
    private static Method M_SECTIONTITLE1;
    /**
     * method for sectionTitle1_
     */
    private static Method M_SECTIONTITLE1_;
    /**
     * method for sectionTitle2
     */
    private static Method M_SECTIONTITLE2;
    /**
     * method for sectionTitle2_
     */
    private static Method M_SECTIONTITLE2_;
    /**
     * method for sectionTitle3
     */
    private static Method M_SECTIONTITLE3;
    /**
     * method for sectionTitle3_
     */
    private static Method M_SECTIONTITLE3_;
    /**
     * method for sectionTitle4
     */
    private static Method M_SECTIONTITLE4;
    /**
     * method for sectionTitle4_
     */
    private static Method M_SECTIONTITLE4_;
    /**
     * method for sectionTitle5
     */
    private static Method M_SECTIONTITLE5;
    /**
     * method for sectionTitle5_
     */
    private static Method M_SECTIONTITLE5_;
    /**
     * method for paragraph
     */
    private static Method M_PARAGRAPH;
    /**
     * method for paragraph_
     */
    private static Method M_PARAGRAPH_;
    /**
     * method for verbatim
     */
    private static Method M_VERBATIM;
    /**
     * method for verbatim_
     */
    private static Method M_VERBATIM_;
    /**
     * method for definedTerm
     */
    private static Method M_DEFINEDTERM;
    /**
     * method for definedTerm_
     */
    private static Method M_DEFINEDTERM_;
    /**
     * method for figureCaption
     */
    private static Method M_FIGURECAPTION;
    /**
     * method for figureCaption_
     */
    private static Method M_FIGURECAPTION_;
    /**
     * method for tableCell
     */
    private static Method M_TABLECELL;
    /**
     * method for tableCell
     */
    private static Method M_TABLECELL_STRING;
    /**
     * method for tableCell_
     */
    private static Method M_TABLECELL_;
    /**
     * method for tableHeaderCell
     */
    private static Method M_TABLEHEADERCELL;
    /**
     * method for tableHeaderCell
     */
    private static Method M_TABLEHEADERCELL_STRING;
    /**
     * method for tableHeaderCell_
     */
    private static Method M_TABLEHEADERCELL_;
    /**
     * method for tableCaption
     */
    private static Method M_TABLECAPTION;
    /**
     * method for tableCaption_
     */
    private static Method M_TABLECAPTION_;
    /**
     * method for figureGraphics
     */
    private static Method M_FIGUREGRAPHICS;
    /**
     * method for horizontalRule
     */
    private static Method M_HORIZONTALRULE;
    /**
     * method for pageBreak
     */
    private static Method M_PAGEBREAK;
    /**
     * method for anchor
     */
    private static Method M_ANCHOR;
    /**
     * method for anchor_
     */
    private static Method M_ANCHOR_;
    /**
     * method for link
     */
    private static Method M_LINK;
    /**
     * method for link_
     */
    private static Method M_LINK_;
    /**
     * method for italic
     */
    private static Method M_ITALIC;
    /**
     * method for italic_
     */
    private static Method M_ITALIC_;
    /**
     * method for bold
     */
    private static Method M_BOLD;
    /**
     * method for bold_
     */
    private static Method M_BOLD_;
    /**
     * method for monospaced
     */
    private static Method M_MONOSPACED;
    /**
     * method for monospaced_
     */
    private static Method M_MONOSPACED_;
    /**
     * method for lineBreak
     */
    private static Method M_LINEBREAK;
    /**
     * method for nonBreakingSpace
     */
    private static Method M_NONBREAKINGSPACE;
    /**
     * method for text
     */
    private static Method M_TEXT;
    /**
     * method for rawText
     */
    private static Method M_RAWTEXT;
    /** method for flush */
    private static Method M_FLUSH;
   /** method for close */
   private static Method M_CLOSE;
}
