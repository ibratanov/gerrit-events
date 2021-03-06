/*
 *  The MIT License
 *
 *  Copyright 2010 Sony Ericsson Mobile Communications. All rights reserved.
 *  Copyright 2014 Sony Mobile Communications AB. All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.sonymobile.tools.gerrit.gerritevents.dto.attr;

import static com.sonymobile.tools.gerrit.gerritevents.GerritJsonEventFactory.getString;
import static com.sonymobile.tools.gerrit.gerritevents.GerritJsonEventFactory.getBoolean;
import com.sonymobile.tools.gerrit.gerritevents.dto.GerritJsonDTO;
import net.sf.json.JSONObject;

import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.NUMBER;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.REVISION;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.REF;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.IS_DRAFT;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.UPLOADER;

/**
 * Represents a Gerrit JSON Patchset DTO.
 * Refers to a specific patchset within a change.
 * @author Robert Sandell &lt;robert.sandell@sonyericsson.com&gt;
 */
public class PatchSet implements GerritJsonDTO {

    /**
     * The patchset number.
     */
    private String number;
    /**
     * Git commit-ish for this patchset.
     */
    private String revision;
    /**
     * The refspec
     */
    private String ref;
    /**
     * The flag for draft patch.
     */
    private boolean draft;
    /**
     * The one who uploaded the patch-set.
     */
    private Account uploader;

    /**
     * Default constructor.
     */
    public PatchSet() {
    }

    /**
     * Constructor that fills with data directly.
     * @param json the JSON object with corresponding data.
     */
    public PatchSet(JSONObject json) {
        this.fromJson(json);
    }

    @Override
    public void fromJson(JSONObject json) {
        number = getString(json, NUMBER);
        revision = getString(json, REVISION);
        draft = getBoolean(json, IS_DRAFT);
        ref = getString(json, REF);
        if (json.containsKey(UPLOADER)) {
            uploader = new Account(json.getJSONObject(UPLOADER));
        }
    }

    /**
     * The patchset number.
     * @return the number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * The patchset number.
     * @param number the number.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Git commit-ish for this patchset.
     * @return the revision commit-ish.
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Git commit-ish for this patchset.
     * @param revision the revision commit-ish.
     */
    public void setRevision(String revision) {
        this.revision = revision;
    }

    /**
     * Gets the refspec, if it exists.
     * This value in the JSON stream-events data was introduced some version after the stream-events command was,
     * so it might not exist for all stream-events versions of Gerrit.
     * @return the refspec.
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the refspec.
     * @param ref the refspec.
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Draft patchset or not.
     * @return true if draft patchset.
     */
    public boolean isDraft() {
        return draft;
    }

    /**
     * Sets the isDraft.
     * @param draft the isDraft.
     */
    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    /**
     * The one who uploaded the patch-set.
     * @return the account of the uploader.
     */
    public Account getUploader() {
        return uploader;
    }

    /**
     * The one who uploaded the patch-set.
     * @param uploader the account of the uploader.
     */
    public void setUploader(Account uploader) {
        this.uploader = uploader;
    }

    @Override
    public boolean equals(Object obj) {
        //CS IGNORE MagicNumber FOR NEXT 15 LINES. REASON: Autogenerated Code.
        //CS IGNORE AvoidInlineConditionals FOR NEXT 15 LINES. REASON: Autogenerated Code.
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PatchSet other = (PatchSet)obj;
        if ((this.number == null) ? (other.number != null) : !this.number.equals(other.number)) {
            return false;
        }
        if ((this.revision == null) ? (other.revision != null) : !this.revision.equals(other.revision)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        //CS IGNORE MagicNumber FOR NEXT 5 LINES. REASON: Autogenerated Code.
        //CS IGNORE AvoidInlineConditionals FOR NEXT 5 LINES. REASON: Autogenerated Code.
        int hash = 7;
        hash = 79 * hash + (this.number != null ? this.number.hashCode() : 0);
        hash = 79 * hash + (this.revision != null ? this.revision.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PatchSet: " + getNumber();
    }


}
