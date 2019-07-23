# The aim of Salt

With Salt we provide a) an easily understandable meta model for
linguistic data and b) an open source API to store, manipulate and
represent data. Salt is an abstract model, poor in linguistic semantics.
As a result, it is agnostic to linguistic schools or theories. The core
model is graph based and therefore keeps the structural restrictions
very low and allows for a wide range of possible linguistic annotations
like syntactic, morphological, coreferential annotations and many more.
You can even model your own very personal annotation as long as it fits
into a graph structure (and so far we have not seen a linguistic
annotation which does not). Furthermore, Salt does not depend on a
specific linguistic tagset and this allows you to use every tagset you
like.

Originally Salt was developed as a common meta model as part of the
SaltNPepper project[^1]. The aim of this project was to develop a
converter framework (called Pepper) that is able to convert several
linguistic formats[^2] into each other. The job of Salt here was to be
able to cover all kinds of different linguistic data with a single
model. In the meantime, Salt was developed further into an own project
and it is now is part of several linguistic software solutions like
ANNIS[^3], Atomic[^4]and of course Pepper.

This article addresses a wider range of readers. We want to satisfy
readers coming from a linguistic background as well as readers coming
from a technical background. As this is a balancing act between
different domains, we try to provide simple additional information for
specific terms and aspects of the different domains. If you get bored at
some point, don\'t hesitate to step over these paragraphs to the more
interesting parts. We always try to improve our software and guides as
well. And since we are an open source community project, this is your
chance to participate. So if you find typos or misleading parts of text,
please let us know and the honor will be yours. Just mail to
<saltnpepper@lists.hu-berlin.de>.

[^1]: see <http://u.hu-berlin.de/saltnpepper>

[^2]: for instance the PennTreebank format, TigerXML, the EXMARaLDA
    format, PAULA, GrAF, RST, CoNLL, the ANNIS format and many more

[^3]: see <http://www.sfb632.uni-potsdam.de/annis/>

[^4]: see <http://linktype.iaa.uni-jena.de/atomic/>